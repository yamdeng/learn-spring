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
public class FlightDTO extends BaseDTO {

    private Long airplaneId; /* 비행기ID */
    private String name; /* 항공편이름 */
    private String nameEn; /* 항공편영문명 */
    private String airCode; /* 비행기코드 */
    private String startIataCode; /* 출발공항코드 */
    private String endIataCode; /* 도착공항코드 */
    private Long captainId; /* 기장ID */
    private LocalDateTime startDate; /* 출발일시 */
    private LocalDateTime endDate; /* 도착일시 */

}
