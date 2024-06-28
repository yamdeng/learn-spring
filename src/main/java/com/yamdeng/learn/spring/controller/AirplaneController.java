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
import com.yamdeng.learn.spring.dto.response.AirplaneDTO;
import com.yamdeng.learn.spring.service.AirplaneService;

@RequestMapping(ApiConstant.AIRPLANE_API_PREFIX)
@RestController
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("")
    public List<AirplaneDTO> selectList() {
        return airplaneService.selectAirplaneList();
    }

    @GetMapping("{id}")
    public AirplaneDTO getDetail(@PathVariable("id") Long id) {
        return airplaneService.getAirplaneById(id);
    }

    @PostMapping("")
    public void create(@RequestBody AirplaneDTO airplaneDTO) {
        airplaneService.insertAirplane(airplaneDTO);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody AirplaneDTO airplaneDTO) {
        airplaneDTO.setId(id);
        airplaneService.updateAirplane(airplaneDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        airplaneService.deleteAirplaneById(id);
    }

}
