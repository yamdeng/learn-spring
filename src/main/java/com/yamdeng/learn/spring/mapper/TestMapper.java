package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yamdeng.learn.spring.domain.Member;
import com.yamdeng.learn.spring.dto.RequestList;
import com.yamdeng.learn.spring.dto.TestDTO;
import com.yamdeng.learn.spring.dto.TestSearchDTO;

@Mapper
public interface TestMapper {

    @Select("SELECT * FROM APP_USER WHERE email = #{email}")
    public Member findByEmail(@Param("email") String email);

    List<TestDTO> selectUserList();

    TestDTO getUserByLoginId(String loginId);

    List<TestDTO> testList(RequestList<?> requestList);

    int testListTotalCount(TestSearchDTO searchDTO);

}
