package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.CodeDetailRequestDTO;
import com.yamdeng.learn.spring.dto.response.CodeDetailDTO;
import com.yamdeng.learn.spring.mapper.CodeDetailMapper;

@Service
public class CodeDetailService {

    @Autowired
    private CodeDetailMapper codeDetailMapper;

    public List<CodeDetailDTO> select(CodeDetailRequestDTO codeDetailRequestDTO) {
        return codeDetailMapper.select(codeDetailRequestDTO);
    }

    public int getTotalCount(CodeDetailRequestDTO codeDetailRequestDTO) {
        return codeDetailMapper.getTotalCount(codeDetailRequestDTO);
    }

    public CodeDetailDTO getCodeDetailById(Long id) {
        return codeDetailMapper.getCodeDetailById(id);
    }

    public int insertCodeDetail(CodeDetailDTO codeDetailDTO) {
        return codeDetailMapper.insertCodeDetail(codeDetailDTO);
    }

    public void updateCodeDetail(CodeDetailDTO codeDetailDTO) {
        codeDetailMapper.updateCodeDetail(codeDetailDTO);
    }

    public void deleteCodeDetailById(long id) {
        codeDetailMapper.deleteCodeDetailById(id);
    }

}
