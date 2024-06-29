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
import com.yamdeng.learn.spring.dto.request.AirplaneRequestDTO;
import com.yamdeng.learn.spring.dto.response.AirplaneDTO;
import com.yamdeng.learn.spring.service.AirplaneService;

@RequestMapping(ApiConstant.AIRPLANE_API_PREFIX)
@RestController
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("")
    public CommonResponseDTO<List<AirplaneDTO>> select(AirplaneRequestDTO airplaneRequestDTO) {
        List<AirplaneDTO> list = airplaneService.select(airplaneRequestDTO);
        int totalCount = airplaneService.getTotalCount(airplaneRequestDTO);
        return CommonResponseDTO.<List<AirplaneDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<AirplaneDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<AirplaneDTO>builder()
                            .data(airplaneService.getAirplaneById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<AirplaneDTO> create(@RequestBody AirplaneDTO airplaneDTO) {
        airplaneService.insertAirplane(airplaneDTO);
        AirplaneDTO createdEntity = airplaneService.getAirplaneById(airplaneDTO.getId());
        return CommonResponseDTO.<AirplaneDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<AirplaneDTO> update(@PathVariable("id") Long id, @RequestBody AirplaneDTO airplaneDTO) {
        airplaneDTO.setId(id);
        airplaneService.updateAirplane(airplaneDTO);
        AirplaneDTO updatedEntity = airplaneService.getAirplaneById(id);
        return CommonResponseDTO.<AirplaneDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        airplaneService.deleteAirplaneById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
