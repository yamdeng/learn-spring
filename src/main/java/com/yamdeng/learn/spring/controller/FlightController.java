package com.yamdeng.learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.constant.ApiConstant;
import com.yamdeng.learn.spring.dto.CommonResponseDTO;
import com.yamdeng.learn.spring.dto.request.FlightRequestDTO;
import com.yamdeng.learn.spring.dto.response.FlightDTO;
import com.yamdeng.learn.spring.service.FlightService;

@RequestMapping(ApiConstant.FLIGHT_API_PREFIX)
@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("")
    public CommonResponseDTO<List<FlightDTO>> select(FlightRequestDTO flightRequestDTO) {
        List<FlightDTO> list = flightService.select(flightRequestDTO);
        int totalCount = flightService.getTotalCount(flightRequestDTO);
        return CommonResponseDTO.<List<FlightDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<FlightDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<FlightDTO>builder()
                            .data(flightService.getFlightById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<FlightDTO> create(@RequestBody FlightDTO flightDTO) {
        flightService.insertFlight(flightDTO);
        FlightDTO createdEntity = flightService.getFlightById(flightDTO.getId());
        return CommonResponseDTO.<FlightDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<FlightDTO> update(@PathVariable("id") Long id, @RequestBody FlightDTO flightDTO) {
        flightDTO.setId(id);
        flightService.updateFlight(flightDTO);
        FlightDTO updatedEntity = flightService.getFlightById(id);
        return CommonResponseDTO.<FlightDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        flightService.deleteFlightById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
