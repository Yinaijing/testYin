package com.winterchen.controller;

import com.winterchen.model.AbnormalData;
import com.winterchen.model.data;
import com.winterchen.model.datas;
import com.winterchen.service.user.dataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * 但是这个模块有没有数，起不起作用要看ServerHandler里面有没有数，这之间的牵制要怎么处理呢？
 * @Author yaj
 */
@RestController
@RequestMapping(value = "/yin")
public class AbnormalController {

    @Autowired dataService dataService;

    private static List<AbnormalData> mylist = new ArrayList<>();
    private static Logger logger = Logger.getLogger(AbnormalController.class);
    @RequestMapping(value = "/ab",method = RequestMethod.GET)
    public List<AbnormalData> abnormalData(){
        mylist.clear();
        mylist.addAll(dataService.getRealtimeAb());
        dataService.ClearList();
        int length = dataService.getRealtimeAb().size();
        if(length == 0) {
            logger.info("清除成功-----------------------");
        } else {
            logger.error("没有清除成功---------------------数据长度" + length);
        }
        return mylist;
    }

    private static List<AbnormalData> ablist = new ArrayList<>();
    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public List<AbnormalData> abData(@RequestParam String ip,@RequestParam String t1, @RequestParam String t2){
        ablist = dataService.selectAb(ip,t1,t2);
        return ablist;
    }

    @RequestMapping(value = "/avg",method = RequestMethod.GET)
    public String avgVolt(@RequestParam String ip,@RequestParam String beginDay,@RequestParam String endDay)
    {
        double a = dataService.avgVoltAb(ip,beginDay,endDay);
        return String.valueOf(a);
    }

    @RequestMapping(value = "/datas",method = RequestMethod.GET)
    public List<datas> getAbDatas(@RequestParam int id,@RequestParam int sec){
        return dataService.getDatas(id,sec);
    }

    /*@RequestMapping(value = "/time",method = RequestMethod.GET)
    public String getDateTime(){
        Calendar c = new GregorianCalendar();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setTime(dataService.getTime(82).getTimestamp());
        c.add(Calendar.SECOND,-30);
        Date stod = c.getTime();
        return f.format(stod);
    }*/
}
