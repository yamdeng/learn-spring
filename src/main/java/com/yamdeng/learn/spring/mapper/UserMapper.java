package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.UserRequestDTO;
import com.yamdeng.learn.spring.dto.response.UserDTO;

@Mapper
public interface UserMapper {

    List<UserDTO> select(UserRequestDTO userRequestDTO);

    int getTotalCount(UserRequestDTO userRequestDTO);

    UserDTO getUserById(long id);

    int insertUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUserById(long id);


}
