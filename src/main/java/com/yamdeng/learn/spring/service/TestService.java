package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.RequestList;
import com.yamdeng.learn.spring.dto.SearchDTO;
import com.yamdeng.learn.spring.dto.UserDTO;
import com.yamdeng.learn.spring.mapper.UserMapper;

@Service
public class TestService {

    @Autowired
    private UserMapper userMapper;

    public Page<UserDTO> testList(SearchDTO searchDTO, Pageable pageable) {
        RequestList<?> requestList = RequestList.builder().data(searchDTO).pageable(pageable).build();
        List<UserDTO> content = userMapper.testList(requestList);
        int totalCount = userMapper.testListTotalCount(searchDTO);

        System.out.println("sort : " + pageable.getSort());
        return new PageImpl<>(content, pageable, totalCount);
    }

}
