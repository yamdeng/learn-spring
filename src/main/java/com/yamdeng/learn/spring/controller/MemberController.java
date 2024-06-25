package com.yamdeng.learn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.domain.Member;
import com.yamdeng.learn.spring.mapper.UserMapper;

@RestController
public class MemberController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/api/member")
    public Member getMethodName() {
        return userMapper.findByEmail("yamdeng@gmail.com");
    }

}
