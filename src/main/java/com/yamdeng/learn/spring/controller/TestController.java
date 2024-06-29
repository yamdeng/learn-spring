package com.yamdeng.learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.dto.TestDTO;
import com.yamdeng.learn.spring.dto.TestSearchDTO;
import com.yamdeng.learn.spring.mapper.TestMapper;
import com.yamdeng.learn.spring.service.TestService;

@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestService testService;

    @GetMapping("/api/test")
    public String test() {
        return "yamdeng";
    }

    @GetMapping("/api/test/user-detail")
    public TestDTO testUserDetail() {
        TestDTO user = TestDTO.builder()
                .name("yamdeng")
                .address("incheon").build();
        return user;
    }

    @GetMapping("/users-direct")
    public List<TestDTO> selectUserListDirect() {
        return testMapper.selectUserList();
    }

    @GetMapping("/api/v1/users")
    public List<TestDTO> selectUserListV1() {
        return testMapper.selectUserList();
    }

    @GetMapping("/api/users")
    public List<TestDTO> selectUserList() {
        return testMapper.selectUserList();
    }

    @GetMapping("/api/getRequestParam")
    public TestDTO getUserByLoginId(@RequestParam("loginId") String loginId) {
        return testMapper.getUserByLoginId(loginId);
    }

    @PostMapping("/api/post-search")
    public ResponseEntity<?> usersPost(@RequestBody TestSearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(testService.testList(searchDTO, pageable));
    }

}
