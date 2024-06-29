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
public class CodeGroupDTO extends BaseDTO {

    private String name; /* 그룹코드명 */
    private String groupCode; /* 그룹코드 */
    private String etc; /* 설명 */

}
