package com.yamdeng.learn.spring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitTest {

    @Test
    void test1() {
        int age = 40;
        assertEquals(40, age);
    }

}
