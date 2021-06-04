package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Hello")
public class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/Consumer")
    public String hello(String s) {
        System.out.println("传入的值为：" + s);


      //restTemplate注入的方式
        String   forObject = restTemplate.getForObject("http://EUREKA-SERVICE:8071/Hello/World?s=" + s,String.class);

        //根据服务名 获取服务列表 根据算法选取某个服务 并访问某个服务的网络位置
       // ServiceInstance serviceInstance  =  loadBalancerClient.choose("EUREKA-SERVICE");
       // String forObject =new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/Hello/World?s="+s,String.class);

        return forObject;
    }


}
