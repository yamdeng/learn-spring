package com.yamdeng.learn.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/aviation")
@RestController
public class AviationController {

    @GetMapping("/users")
    public String selectUserList() {
        return "항공안전 users";
    }

}
