package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.CodeGroupRequestDTO;
import com.yamdeng.learn.spring.dto.response.CodeGroupDTO;
import com.yamdeng.learn.spring.mapper.CodeGroupMapper;

@Service
public class CodeGroupService {

    @Autowired
    private CodeGroupMapper codeGroupMapper;

    public List<CodeGroupDTO> select(CodeGroupRequestDTO codeGroupRequestDTO) {
        return codeGroupMapper.select(codeGroupRequestDTO);
    }

    public int getTotalCount(CodeGroupRequestDTO codeGroupRequestDTO) {
        return codeGroupMapper.getTotalCount(codeGroupRequestDTO);
    }

    public CodeGroupDTO getCodeGroupById(Long id) {
        return codeGroupMapper.getCodeGroupById(id);
    }

    public int insertCodeGroup(CodeGroupDTO codeGroupDTO) {
        return codeGroupMapper.insertCodeGroup(codeGroupDTO);
    }

    public void updateCodeGroup(CodeGroupDTO codeGroupDTO) {
        codeGroupMapper.updateCodeGroup(codeGroupDTO);
    }

    public void deleteCodeGroupById(long id) {
        codeGroupMapper.deleteCodeGroupById(id);
    }

}
