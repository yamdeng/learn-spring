package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.FlightRequestDTO;
import com.yamdeng.learn.spring.dto.response.FlightDTO;

@Mapper
public interface FlightMapper {

    List<FlightDTO> select(FlightRequestDTO flightRequestDTO);

    int getTotalCount(FlightRequestDTO flightRequestDTO);

    FlightDTO getFlightById(long id);

    int insertFlight(FlightDTO flightDTO);

    void updateFlight(FlightDTO flightDTO);

    void deleteFlightById(long id);

}
