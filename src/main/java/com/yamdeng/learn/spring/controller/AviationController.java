package com.yamdeng.learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.dto.UserDTO;
import com.yamdeng.learn.spring.dto.response.AirplaneDTO;
import com.yamdeng.learn.spring.mapper.AirplaneMapper;
import com.yamdeng.learn.spring.mapper.UserMapper;

@RequestMapping("/api/v1/aviation")
@RestController
public class AviationController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AirplaneMapper airplaneMapper;

    @GetMapping("/users")
    public List<UserDTO> selectUserList() {
        return userMapper.selectUserList();
    }

    @GetMapping("/airplanes")
    public List<AirplaneDTO> selectAirplaneList() {
        return airplaneMapper.selectAirplaneList();
    }

}
