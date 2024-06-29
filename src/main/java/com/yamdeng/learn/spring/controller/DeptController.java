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
import com.yamdeng.learn.spring.dto.request.DeptRequestDTO;
import com.yamdeng.learn.spring.dto.response.DeptDTO;
import com.yamdeng.learn.spring.service.DeptService;

@RequestMapping(ApiConstant.DEPT_API_PREFIX)
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("")
    public CommonResponseDTO<List<DeptDTO>> select(DeptRequestDTO deptRequestDTO) {
        List<DeptDTO> list = deptService.select(deptRequestDTO);
        int totalCount = deptService.getTotalCount(deptRequestDTO);
        return CommonResponseDTO.<List<DeptDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<DeptDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<DeptDTO>builder()
                            .data(deptService.getDeptById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<DeptDTO> create(@RequestBody DeptDTO deptDTO) {
        deptService.insertDept(deptDTO);
        DeptDTO createdEntity = deptService.getDeptById(deptDTO.getId());
        return CommonResponseDTO.<DeptDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<DeptDTO> update(@PathVariable("id") Long id, @RequestBody DeptDTO deptDTO) {
        deptDTO.setId(id);
        deptService.updateDept(deptDTO);
        DeptDTO updatedEntity = deptService.getDeptById(id);
        return CommonResponseDTO.<DeptDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        deptService.deleteDeptById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
