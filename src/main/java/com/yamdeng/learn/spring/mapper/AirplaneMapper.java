package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.AirplaneRequestDTO;
import com.yamdeng.learn.spring.dto.response.AirplaneDTO;

@Mapper
public interface AirplaneMapper {

    List<AirplaneDTO> select(AirplaneRequestDTO airplaneRequestDTO);

    int getTotalCount(AirplaneRequestDTO airplaneRequestDTO);

    AirplaneDTO getAirplaneById(long id);

    int insertAirplane(AirplaneDTO airplaneDTO);

    void updateAirplane(AirplaneDTO airplaneDTO);

    void deleteAirplaneById(long id);

}
