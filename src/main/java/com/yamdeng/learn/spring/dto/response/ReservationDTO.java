package com.yamdeng.learn.spring.dto.response;

import java.time.LocalDateTime;

import com.yamdeng.learn.spring.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReservationDTO extends BaseDTO {

    private String title; /* 예약명 */
    private Long userId; /* 사용자ID */
    private LocalDateTime reservationDate; /* 예약일시 */
    private Long flightId; /* 항공편ID */
    private String commentMessage; /* 설명 */

}
