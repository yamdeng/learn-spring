package com.yamdeng.learn.spring.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.yamdeng.learn.spring.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    private static class AddressInfo {
        private String address; /* 주소 */
        private String addressDetail; /* 주소상세 */
        private String zipCode; /* 우편변호 */
    }

    private String loginId; /* 로그인ID */
    private String name; /* 이름 */
    private String nameEn; /* 이름영문명 */
    private String sabun; /* 사번 */
    private Long deptId; /* 부서ID */
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
    private AddressInfo addressInfo;

    @Override
    public UserDTO mappingAssociation() {
        this.addressInfo = AddressInfo.builder()
                            .address(address)
                            .addressDetail(addressDetail)
                            .zipCode(zipCode)
                            .build();
        return this;
    }

}
