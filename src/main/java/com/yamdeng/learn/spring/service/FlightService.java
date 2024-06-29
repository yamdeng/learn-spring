package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.FlightRequestDTO;
import com.yamdeng.learn.spring.dto.response.FlightDTO;
import com.yamdeng.learn.spring.mapper.FlightMapper;

@Service
public class FlightService {

    @Autowired
    private FlightMapper flightMapper;

    public List<FlightDTO> select(FlightRequestDTO flightRequestDTO) {
        return flightMapper.select(flightRequestDTO);
    }

    public int getTotalCount(FlightRequestDTO flightRequestDTO) {
        return flightMapper.getTotalCount(flightRequestDTO);
    }

    public FlightDTO getFlightById(Long id) {
        return flightMapper.getFlightById(id);
    }

    public int insertFlight(FlightDTO flightDTO) {
        return flightMapper.insertFlight(flightDTO);
    }

    public void updateFlight(FlightDTO flightDTO) {
        flightMapper.updateFlight(flightDTO);
    }

    public void deleteFlightById(long id) {
        flightMapper.deleteFlightById(id);
    }

}
