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
public class MenuDTO extends BaseDTO {

    private String name; /* 메뉴명 */
    private String nameEn; /* 메뉴영문명 */
    private String moduleType; /* 모듈타입 */
    private String menuKey; /* 메뉴키 */
    private String menuUpperKey; /* 상위메뉴키 */
    private String menuUrl; /* 메뉴URL */

}
