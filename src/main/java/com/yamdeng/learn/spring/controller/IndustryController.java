package com.yamdeng.learn.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/industry")
@RestController
public class IndustryController {

    @GetMapping("/users")
    public String selectUserList() {
        return "산업안전 users";
    }

}
