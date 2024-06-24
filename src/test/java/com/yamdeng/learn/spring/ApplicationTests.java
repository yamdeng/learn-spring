package com.yamdeng.learn.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yamdeng.learn.spring.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserService() {
		String userServiceName = userService.getName();
		System.out.println("userServiceName : " + userServiceName);
	}

	@Test
	void testModuleName() {
		String moduleName = userService.getModuleName();
		assertEquals("TEST", moduleName);
		// assertEquals("user", moduleName);
	}

}
