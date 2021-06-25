package com.controller;

import com.common.BizException;
import com.entity.User;
import com.services.UserSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/bizExe")
    public boolean bizExe(@RequestParam String name) {

        //如果姓名为空就手动抛出一个自定义的异常！
        if(name.equals("aa")){
            throw  new BizException("-1","用户姓名不能为空！");
        }
        return true;
    }

    @RequestMapping("/bizExeNull")
    public boolean bizExeNull(@RequestParam String name) {

        //如果姓名为空就手动抛出一个自定义的异常！
        String a = null;
         a.equals("aa") ;

        return true;
    }
    @RequestMapping("/bizExeTrans")
    public boolean bizExeTrans(@RequestParam String name) {

        //如果姓名为空就手动抛出一个自定义的异常！
         Integer.parseInt(name);
        return true;
    }
}
