package com.sonnet.sonnet.service;

import com.sonnet.sonnet.pojo.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String username) {
        return helloProperties.getPrefix() + " <---> " + username + "<--->" + helloProperties.getSuffix();
    }
}
