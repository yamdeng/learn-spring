package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.MenuRequestDTO;
import com.yamdeng.learn.spring.dto.response.MenuDTO;
import com.yamdeng.learn.spring.mapper.MenuMapper;

@Service
public class MenuService {

    @Autowired
    private MenuMapper MenuMapper;

    public List<MenuDTO> select(MenuRequestDTO menuRequestDTO) {
        return MenuMapper.select(menuRequestDTO);
    }

    public int getTotalCount(MenuRequestDTO menuRequestDTO) {
        return MenuMapper.getTotalCount(menuRequestDTO);
    }

    public MenuDTO getMenuById(Long id) {
        return MenuMapper.getMenuById(id);
    }

    public int insertMenu(MenuDTO menuDTO) {
        return MenuMapper.insertMenu(menuDTO);
    }

    public void updateMenu(MenuDTO menuDTO) {
        MenuMapper.updateMenu(menuDTO);
    }

    public void deleteMenuById(long id) {
        MenuMapper.deleteMenuById(id);
    }

}
