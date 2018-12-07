package com.winterchen;

import com.winterchen.netty.server.TcpServer;
import io.netty.channel.ChannelFuture;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.File;
import java.util.concurrent.ConcurrentMap;

@SpringBootApplication
@MapperScan("com.winterchen.dao")
public class Springboot2MybatisDemoApplication implements CommandLineRunner,ApplicationContextAware {

	private static ApplicationContext applicationContext;
	private static DefaultListableBeanFactory defaultListableBeanFactory;

	public static void main(String[] args) {
		SpringApplication.run(Springboot2MybatisDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final TcpServer tcpServer = new TcpServer();
		ChannelFuture future = tcpServer.startServer();

		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				tcpServer.destory();
			}
		});
		future.channel().closeFuture().syncUninterruptibly();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		defaultListableBeanFactory = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();
	}

	public static <T> T getBean(Class<T> clazz) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
		String className = clazz.getName();
		defaultListableBeanFactory.registerBeanDefinition(className, beanDefinitionBuilder.getBeanDefinition());
		return (T) applicationContext.getBean(className);
	}

	public static void destroy(String className){
		defaultListableBeanFactory.removeBeanDefinition(className);
		System.out.println("destroy " + className);
	}

}
