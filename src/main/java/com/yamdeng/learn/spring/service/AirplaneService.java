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

    public void insertAriplane(AirplaneDTO airplaneDTO) {
        airplaneMapper.insertAriplane(airplaneDTO);
    }

    public void updateAriplane(AirplaneDTO airplaneDTO) {
        airplaneMapper.updateAriplane(airplaneDTO);
    }

    public void deleteAirplaneById(long id) {
        airplaneMapper.deleteAirplaneById(id);
    }

}
