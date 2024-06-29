package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.CodeGroupRequestDTO;
import com.yamdeng.learn.spring.dto.response.CodeGroupDTO;

@Mapper
public interface CodeGroupMapper {

    List<CodeGroupDTO> select(CodeGroupRequestDTO codeGroupRequestDTO);

    int getTotalCount(CodeGroupRequestDTO codeGroupRequestDTO);

    CodeGroupDTO getCodeGroupById(long id);

    int insertCodeGroup(CodeGroupDTO codeGroupDTO);

    void updateCodeGroup(CodeGroupDTO codeGroupDTO);

    void deleteCodeGroupById(long id);

}
