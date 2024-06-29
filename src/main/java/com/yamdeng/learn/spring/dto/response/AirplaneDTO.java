package com.yamdeng.learn.spring.dto.response;

import java.time.LocalDateTime;
import java.util.List;

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
public class AirplaneDTO extends BaseDTO {

    private String name; /* 비행기이름 */
    private String nameEn; /* 비행기영문명 */
    private String airCode; /* 비행기코드 */
    private String countryCode; /* 국가코드 */
    private LocalDateTime lastPainDate; /* 최종비행시간 */
    private LocalDateTime lastFixDate; /* 최종수리시간 */
    private Double size; /* 크기 */
    private List<FlightDTO> flightList; /* 항공편 정보 목록 */

}
