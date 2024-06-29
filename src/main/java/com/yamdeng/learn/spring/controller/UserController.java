package com.yamdeng.learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.constant.ApiConstant;
import com.yamdeng.learn.spring.dto.CommonResponseDTO;
import com.yamdeng.learn.spring.dto.request.UserRequestDTO;
import com.yamdeng.learn.spring.dto.response.UserDTO;
import com.yamdeng.learn.spring.service.UserService;

@RequestMapping(ApiConstant.USER_API_PREFIX)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public CommonResponseDTO<List<UserDTO>> select(UserRequestDTO userRequestDTO) {
        List<UserDTO> list = userService.select(userRequestDTO);
        int totalCount = userService.getTotalCount(userRequestDTO);
        return CommonResponseDTO.<List<UserDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<UserDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<UserDTO>builder()
                            .data(userService.getUserById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<UserDTO> create(@RequestBody UserDTO UserDTO) {
        userService.insertUser(UserDTO);
        UserDTO createdEntity = userService.getUserById(UserDTO.getId());
        return CommonResponseDTO.<UserDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<UserDTO> update(@PathVariable("id") Long id, @RequestBody UserDTO UserDTO) {
        UserDTO.setId(id);
        userService.updateUser(UserDTO);
        UserDTO updatedEntity = userService.getUserById(id);
        return CommonResponseDTO.<UserDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        userService.deleteUserById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
