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
import com.yamdeng.learn.spring.dto.request.ReservationRequestDTO;
import com.yamdeng.learn.spring.dto.response.ReservationDTO;
import com.yamdeng.learn.spring.service.ReservationService;

@RequestMapping(ApiConstant.RESERVATION_API_PREFIX)
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("")
    public CommonResponseDTO<List<ReservationDTO>> select(ReservationRequestDTO reservationRequestDTO) {
        List<ReservationDTO> list = reservationService.select(reservationRequestDTO);
        int totalCount = reservationService.getTotalCount(reservationRequestDTO);
        return CommonResponseDTO.<List<ReservationDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<ReservationDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<ReservationDTO>builder()
                            .data(reservationService.getReservationById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<ReservationDTO> create(@RequestBody ReservationDTO reservationDTO) {
        reservationService.insertReservation(reservationDTO);
        ReservationDTO createdEntity = reservationService.getReservationById(reservationDTO.getId());
        return CommonResponseDTO.<ReservationDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<ReservationDTO> update(@PathVariable("id") Long id, @RequestBody ReservationDTO reservationDTO) {
        reservationDTO.setId(id);
        reservationService.updateReservation(reservationDTO);
        ReservationDTO updatedEntity = reservationService.getReservationById(id);
        return CommonResponseDTO.<ReservationDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
