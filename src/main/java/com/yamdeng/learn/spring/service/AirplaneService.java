package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.response.AirplaneDTO;
import com.yamdeng.learn.spring.mapper.AirplaneMapper;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneMapper airplaneMapper;

    public List<AirplaneDTO> selectAirplaneList() {
        return airplaneMapper.selectAirplaneList();
    }

    public AirplaneDTO getAirplaneById(Long id) {
        return airplaneMapper.getAirplaneById(id);
    }

    public void insertAirplane(AirplaneDTO airplaneDTO) {
        airplaneMapper.insertAirplane(airplaneDTO);
    }

    public void updateAirplane(AirplaneDTO airplaneDTO) {
        airplaneMapper.updateAirplane(airplaneDTO);
    }

    public void deleteAirplaneById(long id) {
        airplaneMapper.deleteAirplaneById(id);
    }

}
