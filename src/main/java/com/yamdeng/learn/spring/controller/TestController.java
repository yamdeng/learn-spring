package com.yamdeng.learn.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.dto.UserDTO;


@RestController
public class TestController {

    @GetMapping("/api/test")
    public String getMethodName() {
        return "yamdeng";
    }

    @GetMapping("/api/test-user")
    public UserDTO getTestUser() {
        UserDTO user = new UserDTO();
        user.setName("yamdeng");
        user.setAddress("incheon");
        return user;
    }

}
