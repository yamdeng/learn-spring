package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.AirplaneRequestDTO;
import com.yamdeng.learn.spring.dto.request.FlightRequestDTO;
import com.yamdeng.learn.spring.dto.response.AirplaneDTO;
import com.yamdeng.learn.spring.dto.response.FlightDTO;
import com.yamdeng.learn.spring.mapper.AirplaneMapper;
import com.yamdeng.learn.spring.mapper.FlightMapper;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneMapper airplaneMapper;

    @Autowired
    private FlightMapper flightMapper;


    private List<FlightDTO> getFlightList() {
        return flightMapper.select(FlightRequestDTO.builder().build());
    }
    
    public List<AirplaneDTO> select(AirplaneRequestDTO airplaneRequestDTO) {
        List<FlightDTO> flightList = getFlightList();
        List<AirplaneDTO> list = airplaneMapper.select(airplaneRequestDTO);
        list.stream().forEach(info -> {
            info.setFlightList(flightList);
        });
        return list;
    }

    public int getTotalCount(AirplaneRequestDTO airplaneRequestDTO) {
        return airplaneMapper.getTotalCount(airplaneRequestDTO);
    }

    public AirplaneDTO getAirplaneById(Long id) {
        List<FlightDTO> flightList = getFlightList();
        AirplaneDTO detailInfo = airplaneMapper.getAirplaneById(id);
        if(detailInfo != null) {
            detailInfo.setFlightList(flightList);
        }
        return detailInfo;
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
