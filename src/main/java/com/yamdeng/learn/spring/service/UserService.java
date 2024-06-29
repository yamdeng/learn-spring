package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.UserRequestDTO;
import com.yamdeng.learn.spring.dto.response.UserDTO;
import com.yamdeng.learn.spring.mapper.UserMapper;

@Service
public class UserService {    

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> select(UserRequestDTO userRequestDTO) {
        return userMapper.select(userRequestDTO);
    }

    public int getTotalCount(UserRequestDTO userRequestDTO) {
        return userMapper.getTotalCount(userRequestDTO);
    }

    public UserDTO getAirplaneById(Long id) {
        return userMapper.getUserById(id);
    }

    public int insertAirplane(UserDTO userDTO) {
        return userMapper.insertUser(userDTO);
    }

    public void updateAirplane(UserDTO userDTO) {
        userMapper.updateUser(userDTO);
    }

    public void deleteAirplaneById(long id) {
        userMapper.deleteUserById(id);
    }

}
