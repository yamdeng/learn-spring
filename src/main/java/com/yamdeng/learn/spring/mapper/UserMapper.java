package com.yamdeng.learn.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yamdeng.learn.spring.domain.Member;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM APP_USER WHERE email = #{email}")
    public Member findByEmail(@Param("email") String email);

}
