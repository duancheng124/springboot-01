package com.poxiao.springboot01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Hello {
    @RequestMapping("/hello")
    public String Hello(){
        return "hello world";
    }
}