package com.winterchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/myindex")
    private String helloIndex(){
        return ("index");

    }
    @GetMapping("/data")
    private String hello(){
        return ("data");
    }
}
