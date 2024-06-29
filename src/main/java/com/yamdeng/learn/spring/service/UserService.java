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
        List<UserDTO> list = userMapper.select(userRequestDTO);
        list.stream().forEach(info -> {
            info.mappingAssociation();
        });
        return list;
    }

    public int getTotalCount(UserRequestDTO userRequestDTO) {
        return userMapper.getTotalCount(userRequestDTO);
    }

    public UserDTO getUserById(Long id) {
        UserDTO detailInfo = userMapper.getUserById(id);
        if(detailInfo != null) {
            detailInfo.mappingAssociation();
        }
        return detailInfo;
    }

    public int insertUser(UserDTO userDTO) {
        return userMapper.insertUser(userDTO);
    }

    public void updateUser(UserDTO userDTO) {
        userMapper.updateUser(userDTO);
    }

    public void deleteUserById(long id) {
        userMapper.deleteUserById(id);
    }

}
