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
public class DeptDTO extends BaseDTO{

    private String name; /* 부서명 */
    private String nameEn; /* 부서영문명 */
    private String deptKey; /* 부서키 */
    private String deptUpperKey; /* 부서상위키 */
    private String status; /* 부서상태 */

}
