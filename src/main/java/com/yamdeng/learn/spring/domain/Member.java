package com.yamdeng.learn.spring.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
public class Member {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate create_date;
    private LocalDate update_date;

    public Member() {
        this.create_date = LocalDate.now();
        this.update_date = LocalDate.now();
    }

    @Builder
    public Member(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.create_date = LocalDate.now();
        this.update_date = LocalDate.now();
    }

}

