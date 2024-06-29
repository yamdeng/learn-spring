package com.yamdeng.learn.spring.mapper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yamdeng.learn.spring.dto.request.AirplaneRequestDTO;
import com.yamdeng.learn.spring.dto.response.AirplaneDTO;

@SpringBootTest
public class AirplaneMapperTest {

    @Autowired
    private AirplaneMapper airplaneMapper;

    @Test
    void test() {
        List<AirplaneDTO> result = airplaneMapper.select(AirplaneRequestDTO.builder().build());
        assertTrue(result.size() > 1);
    }

}
