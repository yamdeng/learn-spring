package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.ReservationRequestDTO;
import com.yamdeng.learn.spring.dto.response.ReservationDTO;

@Mapper
public interface ReservationMapper {

    List<ReservationDTO> select(ReservationRequestDTO requestDTO);

    int getTotalCount(ReservationRequestDTO requestDTO);

    ReservationDTO getReservationById(long id);

    int insertReservation(ReservationDTO reservationDTO);

    void updateReservation(ReservationDTO reservationDTO);

    void deleteReservationById(long id);

}
