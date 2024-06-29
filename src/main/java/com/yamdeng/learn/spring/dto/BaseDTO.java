package com.yamdeng.learn.spring.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {

    private Long id; /* ID */
    private Integer createUserId; /* 등록자 ID */
    private Integer updateUserId; /* 수정자 ID */
    private LocalDateTime createDate; /* 등록일 */
    private LocalDateTime updateDate; /* 수정일 */
    private Boolean isDelete; /* 삭제 여부 */

    // hook method : 관계 설정시에 사용
    public BaseDTO mappingAssociation() {
        return this;
    }

}
