package com.controller;

import com.entity.User;
import com.services.UserSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class Controller {

    @Autowired
    private UserSevices userServices;
    @RequestMapping("/World")
    public String hello(String s){
        System.out.println("传入的值为："+s);
        return "传入的值为："+s;
    }


    @RequestMapping("/getUser")
    public String  getUser(String fname_l2){
       User user =  userServices.getUser(fname_l2);
    return "FID:"+user.getFID()+"  FPASSWORD:"+user.getFPASSWORD();
    }

}
