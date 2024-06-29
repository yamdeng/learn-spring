package com.yamdeng.learn.spring.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDTO {

    private Integer id; /* ID */
    private Integer createUserId; /* 등록자 ID */
    private Integer updateUserId; /* 수정자 ID */
    private LocalDateTime createDate; /* 등록일 */
    private LocalDateTime updateDate; /* 수정일 */
    private Boolean isDelete; /* 삭제 여부 */
    private String name; /* 이름 */
    private String nameEn; /* 이름영문명 */
    private String sabun; /* 사번 */
    private Integer deptId; /* 부서ID */
    private String positionTitle; /* 사용자직책명 */
    private String positionTitleEn; /* 사용자직책영문명 */
    private String phoneNumber; /* 핸드폰번호 */
    private String companyTel; /* 회사전화번호 */
    private String email; /* 이메일 */
    private String address; /* 주소 */
    private String addressDetail; /* 주소상세 */
    private String zipCode; /* 우편변호 */
    private LocalDate joinDate; /* 입사일 */
    private String status; /* 사용자상태 */

}
