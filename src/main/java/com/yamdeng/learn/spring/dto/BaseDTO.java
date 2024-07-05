package com.yamdeng.learn.spring.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {

    @Schema(description = "ID")
    private Long id; /* ID */
    @Schema(description = "등록자 ID")
    private Long createUserId; /* 등록자 ID */
    @Schema(description = "수정자 ID")
    private Long updateUserId; /* 수정자 ID */
    @Schema(description = "등록일")
    private LocalDateTime createDate; /* 등록일 */
    @Schema(description = "수정일")
    private LocalDateTime updateDate; /* 수정일 */
    @Schema(description = "삭제 여부")
    private Boolean isDelete; /* 삭제 여부 */

    // hook method : 관계 설정시에 사용
    public BaseDTO mappingAssociation() {
        return this;
    }

}
