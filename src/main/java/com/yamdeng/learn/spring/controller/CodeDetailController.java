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
import com.yamdeng.learn.spring.dto.request.CodeDetailRequestDTO;
import com.yamdeng.learn.spring.dto.response.CodeDetailDTO;
import com.yamdeng.learn.spring.service.CodeDetailService;

@RequestMapping(ApiConstant.CODE_API_PREFIX)
@RestController
public class CodeDetailController {

    @Autowired
    private CodeDetailService codeDetailService;

    @GetMapping("")
    public CommonResponseDTO<List<CodeDetailDTO>> select(CodeDetailRequestDTO codeDetailRequestDTO) {
        List<CodeDetailDTO> list = codeDetailService.select(codeDetailRequestDTO);
        int totalCount = codeDetailService.getTotalCount(codeDetailRequestDTO);
        return CommonResponseDTO.<List<CodeDetailDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<CodeDetailDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<CodeDetailDTO>builder()
                            .data(codeDetailService.getCodeDetailById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<CodeDetailDTO> create(@RequestBody CodeDetailDTO codeDetailDTO) {
        codeDetailService.insertCodeDetail(codeDetailDTO);
        CodeDetailDTO createdEntity = codeDetailService.getCodeDetailById(codeDetailDTO.getId());
        return CommonResponseDTO.<CodeDetailDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<CodeDetailDTO> update(@PathVariable("id") Long id, @RequestBody CodeDetailDTO codeDetailDTO) {
        codeDetailDTO.setId(id);
        codeDetailService.updateCodeDetail(codeDetailDTO);
        CodeDetailDTO updatedEntity = codeDetailService.getCodeDetailById(id);
        return CommonResponseDTO.<CodeDetailDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        codeDetailService.deleteCodeDetailById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
