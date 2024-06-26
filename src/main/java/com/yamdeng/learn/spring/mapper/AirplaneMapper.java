package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.response.AirplaneDTO;

@Mapper
public interface AirplaneMapper {

    List<AirplaneDTO> selectAirplaneList();

    AirplaneDTO getAirplaneById(long id);

    void insertAriplane(AirplaneDTO airplaneDTO);

    void updateAriplane(AirplaneDTO airplaneDTO);

    void deleteAirplaneById(long id);

}
