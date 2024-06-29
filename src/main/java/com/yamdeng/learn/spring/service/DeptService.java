package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.DeptRequestDTO;
import com.yamdeng.learn.spring.dto.response.DeptDTO;
import com.yamdeng.learn.spring.mapper.DeptMapper;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<DeptDTO> select(DeptRequestDTO deptRequestDTO) {
        return deptMapper.select(deptRequestDTO);
    }

    public int getTotalCount(DeptRequestDTO deptRequestDTO) {
        return deptMapper.getTotalCount(deptRequestDTO);
    }

    public DeptDTO getDeptById(Long id) {
        return deptMapper.getDeptById(id);
    }

    public int insertDept(DeptDTO deptDTO) {
        return deptMapper.insertDept(deptDTO);
    }

    public void updateDept(DeptDTO deptDTO) {
        deptMapper.updateDept(deptDTO);
    }

    public void deleteDeptById(long id) {
        deptMapper.deleteDeptById(id);
    }

}
