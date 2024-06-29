package com.yamdeng.learn.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yamdeng.learn.spring.service.TestService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		testService.test();
	}

}
