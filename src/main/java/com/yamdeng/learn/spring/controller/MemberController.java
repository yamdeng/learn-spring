package com.yamdeng.learn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.domain.Member;
import com.yamdeng.learn.spring.dto.SearchDTO;
import com.yamdeng.learn.spring.dto.UserDTO;
import com.yamdeng.learn.spring.mapper.UserMapper;
import com.yamdeng.learn.spring.service.TestService;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MemberController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestService testService;

    @GetMapping("/api/member-test")
    public Member getMethodName() {
        return userMapper.findByEmail("yamdeng@gmail.com");
    }

    @GetMapping("/users-direct")
    public List<UserDTO> selectUserListDirect() {
        return userMapper.selectUserList();
    }

    @GetMapping("/api/v1/users")
    public List<UserDTO> selectUserListV1() {
        return userMapper.selectUserList();
    }

    @GetMapping("/api/users")
    public List<UserDTO> selectUserList() {
        return userMapper.selectUserList();
    }

    @GetMapping("/api/getUserByLoginId")
    public UserDTO getUserByLoginId(@RequestParam("loginId") String loginId) {
        return userMapper.getUserByLoginId(loginId);
    }

    @PostMapping("/api/users-post")
    public ResponseEntity<?> usersPost(@RequestBody SearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(testService.testList(searchDTO, pageable));
    }

    @GetMapping("/api/users-get")
    public ResponseEntity<?> usersGet(SearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(testService.testList(searchDTO, pageable));
    }

}
