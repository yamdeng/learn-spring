package com.yamdeng.learn.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yamdeng.learn.spring.domain.Member;
import com.yamdeng.learn.spring.dto.UserDTO;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM APP_USER WHERE email = #{email}")
    public Member findByEmail(@Param("email") String email);

    List<UserDTO> selectUserList();

    UserDTO getUserByLoginId(String loginId);

}
