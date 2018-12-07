package com.winterchen.controller;

import com.github.pagehelper.PageHelper;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")    //TODO : yaj，那为什么要这么个父路径呢？直接配置prefix不就行了吗？哦，可能只有这个类需要，其他的不需要呗。
public class UserController {

    @Autowired     //TODO : 用了这个，就可以自动装配这个类，不用去new，因为后面会用到，如果你根本用不到那当然就不用Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserDomain user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
}
