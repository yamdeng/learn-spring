package com.yamdeng.learn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.domain.Member;
import com.yamdeng.learn.spring.dto.UserDTO;
import com.yamdeng.learn.spring.mapper.UserMapper;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/api/member-test")
    public Member getMethodName() {
        return userMapper.findByEmail("yamdeng@gmail.com");
    }

    @GetMapping("/api/users")
    public List<UserDTO> selectUserList() {
        return userMapper.selectUserList();
    }

    @GetMapping("/api/getUserByLoginId")
    public UserDTO getUserByLoginId(@RequestParam("loginId") String loginId) {
        return userMapper.getUserByLoginId(loginId);
    }

}
