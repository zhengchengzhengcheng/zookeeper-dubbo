package com.cg.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cg.service.HelloService;
import org.springframework.stereotype.Component;


@Service        //用的dubbo的注解，表明这是一个分布式服务
@Component      //注册为spring bean
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String message) {
        return "hello："+message;
    }
}
