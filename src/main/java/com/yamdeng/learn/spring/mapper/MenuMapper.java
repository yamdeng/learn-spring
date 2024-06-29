package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.MenuRequestDTO;
import com.yamdeng.learn.spring.dto.response.MenuDTO;

@Mapper
public interface MenuMapper {

    List<MenuDTO> select(MenuRequestDTO menuRequestDTO);

    int getTotalCount(MenuRequestDTO menuRequestDTO);

    MenuDTO getMenuById(long id);

    int insertMenu(MenuDTO menuDTO);

    void updateMenu(MenuDTO menuDTO);

    void deleteMenuById(long id);

}
