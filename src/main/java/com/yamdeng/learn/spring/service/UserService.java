package com.yamdeng.learn.spring.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {    

    private String moduleName = "";

    @PostConstruct
    public void init() {
        System.out.println("UserService PostConstruct init");
        this.moduleName = "TEST";
    }

    public String getName() {
        return "UserService Autowired";
    }

    public String getModuleName() {
        return this.moduleName;
    }

}
