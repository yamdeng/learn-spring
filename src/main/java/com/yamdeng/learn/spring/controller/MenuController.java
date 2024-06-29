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
import com.yamdeng.learn.spring.dto.request.MenuRequestDTO;
import com.yamdeng.learn.spring.dto.response.MenuDTO;
import com.yamdeng.learn.spring.service.MenuService;

@RequestMapping(ApiConstant.MENU_API_PREFIX)
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("")
    public CommonResponseDTO<List<MenuDTO>> select(MenuRequestDTO menuRequestDTO) {
        List<MenuDTO> list = menuService.select(menuRequestDTO);
        int totalCount = menuService.getTotalCount(menuRequestDTO);
        return CommonResponseDTO.<List<MenuDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<MenuDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<MenuDTO>builder()
                            .data(menuService.getMenuById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<MenuDTO> create(@RequestBody MenuDTO menuDTO) {
        menuService.insertMenu(menuDTO);
        MenuDTO createdEntity = menuService.getMenuById(menuDTO.getId());
        return CommonResponseDTO.<MenuDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<MenuDTO> update(@PathVariable("id") Long id, @RequestBody MenuDTO menuDTO) {
        menuDTO.setId(id);
        menuService.updateMenu(menuDTO);
        MenuDTO updatedEntity = menuService.getMenuById(id);
        return CommonResponseDTO.<MenuDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        menuService.deleteMenuById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
