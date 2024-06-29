package com.yamdeng.learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.constant.ApiConstant;
import com.yamdeng.learn.spring.dto.CommonResponseDTO;
import com.yamdeng.learn.spring.dto.request.CodeGroupRequestDTO;
import com.yamdeng.learn.spring.dto.response.CodeGroupDTO;
import com.yamdeng.learn.spring.service.CodeGroupService;

@RequestMapping(ApiConstant.CODE_GROUP_API_PREFIX)
@RestController
public class CodeGroupController {

    @Autowired
    private CodeGroupService codeGroupService;

    @GetMapping("")
    public CommonResponseDTO<List<CodeGroupDTO>> select(CodeGroupRequestDTO codeGroupRequestDTO) {
        List<CodeGroupDTO> list = codeGroupService.select(codeGroupRequestDTO);
        int totalCount = codeGroupService.getTotalCount(codeGroupRequestDTO);
        return CommonResponseDTO.<List<CodeGroupDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<CodeGroupDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<CodeGroupDTO>builder()
                            .data(codeGroupService.getCodeGroupById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<CodeGroupDTO> create(@RequestBody CodeGroupDTO codeGroupDTO) {
        codeGroupService.insertCodeGroup(codeGroupDTO);
        CodeGroupDTO createdEntity = codeGroupService.getCodeGroupById(codeGroupDTO.getId());
        return CommonResponseDTO.<CodeGroupDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<CodeGroupDTO> update(@PathVariable("id") Long id, @RequestBody CodeGroupDTO codeGroupDTO) {
        codeGroupDTO.setId(id);
        codeGroupService.updateCodeGroup(codeGroupDTO);
        CodeGroupDTO updatedEntity = codeGroupService.getCodeGroupById(id);
        return CommonResponseDTO.<CodeGroupDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        codeGroupService.deleteCodeGroupById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
