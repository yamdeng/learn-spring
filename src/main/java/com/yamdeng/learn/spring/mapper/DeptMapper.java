package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.DeptRequestDTO;
import com.yamdeng.learn.spring.dto.response.DeptDTO;

@Mapper
public interface DeptMapper {

    List<DeptDTO> select(DeptRequestDTO deptRequestDTO);

    int getTotalCount(DeptRequestDTO deptRequestDTO);

    DeptDTO getDeptById(long id);

    int insertDept(DeptDTO deptDTO);

    void updateDept(DeptDTO deptDTO);

    void deleteDeptById(long id);

}
