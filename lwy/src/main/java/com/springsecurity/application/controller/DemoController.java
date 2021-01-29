package com.springsecurity.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/")
    public String home(){
        return "hello spring boot";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
