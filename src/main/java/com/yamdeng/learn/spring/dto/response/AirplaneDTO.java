package com.yamdeng.learn.spring.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.yamdeng.learn.spring.dto.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
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

    @Schema(description = "비행기이름")
    @NotEmpty
    private String name; /* 비행기이름 */

    @Schema(description = "비행기영문명")
    @NotEmpty
    private String nameEn; /* 비행기영문명 */

    @Schema(description = "비행기코드")
    @NotEmpty
    private String airCode; /* 비행기코드 */

    @Schema(description = "국가코드")
    private String countryCode; /* 국가코드 */

    @Schema(description = "최종비행시간")
    private LocalDateTime lastPainDate; /* 최종비행시간 */

    @Schema(description = "최종수리시간")
    private LocalDateTime lastFixDate; /* 최종수리시간 */

    @Schema(description = "크기")
    private Double size; /* 크기 */

}
