package com.yamdeng.learn.spring.dto.response;

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
public class MessageDTO extends BaseDTO {

    private String messageKey; /* 메시지키 */
    private String message; /* 메시지 */
    private String messageEn; /* 메시지(영문) */
    private String etc; /* 설명 */

}
