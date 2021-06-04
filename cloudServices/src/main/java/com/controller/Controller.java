package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class Controller {

    @RequestMapping("/World")
    public String hello(String s){
        System.out.println("传入的值为："+s);
        return "传入的值为："+s;
    }

}
