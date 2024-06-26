package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.RequestList;
import com.yamdeng.learn.spring.dto.TestDTO;
import com.yamdeng.learn.spring.dto.TestSearchDTO;
import com.yamdeng.learn.spring.mapper.TestMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public Page<TestDTO> testList(TestSearchDTO searchDTO, Pageable pageable) {
        RequestList<?> requestList = RequestList.builder().data(searchDTO).pageable(pageable).build();
        List<TestDTO> content = testMapper.testList(requestList);
        int totalCount = testMapper.testListTotalCount(searchDTO);
        return new PageImpl<>(content, pageable, totalCount);
    }

    public void test() {
        log.info("test");
    }

}
