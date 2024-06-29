package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.AirplaneRequestDTO;
import com.yamdeng.learn.spring.dto.response.AirplaneDTO;
import com.yamdeng.learn.spring.mapper.AirplaneMapper;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneMapper airplaneMapper;

    public List<AirplaneDTO> selectAirplaneListPage(AirplaneRequestDTO airplaneRequestDTO) {
        return airplaneMapper.selectAirplaneListPage(airplaneRequestDTO);
    }

    public int getTotalCount(AirplaneRequestDTO airplaneRequestDTO) {
        return airplaneMapper.getTotalCount(airplaneRequestDTO);
    }

    public List<AirplaneDTO> selectAirplaneList() {
        return airplaneMapper.selectAirplaneList();
    }

    public AirplaneDTO getAirplaneById(Long id) {
        return airplaneMapper.getAirplaneById(id);
    }

    public int insertAirplane(AirplaneDTO airplaneDTO) {
        return airplaneMapper.insertAirplane(airplaneDTO);
    }

    public void updateAirplane(AirplaneDTO airplaneDTO) {
        airplaneMapper.updateAirplane(airplaneDTO);
    }

    public void deleteAirplaneById(long id) {
        airplaneMapper.deleteAirplaneById(id);
    }

}
