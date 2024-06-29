package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.CodeDetailRequestDTO;
import com.yamdeng.learn.spring.dto.response.CodeDetailDTO;

@Mapper
public interface CodeDetailMapper {

    List<CodeDetailDTO> select(CodeDetailRequestDTO codeDetailRequestDTO);

    int getTotalCount(CodeDetailRequestDTO codeDetailRequestDTO);

    CodeDetailDTO getCodeDetailById(long id);

    int insertCodeDetail(CodeDetailDTO codeDetail);

    void updateCodeDetail(CodeDetailDTO codeDetail);

    void deleteCodeDetailById(long id);

}
