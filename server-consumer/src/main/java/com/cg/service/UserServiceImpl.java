package com.cg.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Reference
    private HelloService helloService;

    public String say(){
        return helloService.sayHello("小车");
    }
}
