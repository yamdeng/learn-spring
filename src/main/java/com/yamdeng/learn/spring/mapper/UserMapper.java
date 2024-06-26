package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yamdeng.learn.spring.domain.Member;
import com.yamdeng.learn.spring.dto.RequestList;
import com.yamdeng.learn.spring.dto.SearchDTO;
import com.yamdeng.learn.spring.dto.UserDTO;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM APP_USER WHERE email = #{email}")
    public Member findByEmail(@Param("email") String email);

    List<UserDTO> selectUserList();

    UserDTO getUserByLoginId(String loginId);

    List<UserDTO> testList(RequestList<?> requestList);

    int testListTotalCount(SearchDTO searchDTO);

}
