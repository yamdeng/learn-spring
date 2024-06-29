package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.ReservationRequestDTO;
import com.yamdeng.learn.spring.dto.response.ReservationDTO;
import com.yamdeng.learn.spring.mapper.ReservationMapper;

@Service
public class ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    public List<ReservationDTO> select(ReservationRequestDTO reservationRequestDTO) {
        return reservationMapper.select(reservationRequestDTO);
    }

    public int getTotalCount(ReservationRequestDTO reservationRequestDTO) {
        return reservationMapper.getTotalCount(reservationRequestDTO);
    }

    public ReservationDTO getReservationById(Long id) {
        return reservationMapper.getReservationById(id);
    }

    public int insertReservation(ReservationDTO reservationDTO) {
        return reservationMapper.insertReservation(reservationDTO);
    }

    public void updateReservation(ReservationDTO reservationDTO) {
        reservationMapper.updateReservation(reservationDTO);
    }

    public void deleteReservationById(long id) {
        reservationMapper.deleteReservationById(id);
    }

}
