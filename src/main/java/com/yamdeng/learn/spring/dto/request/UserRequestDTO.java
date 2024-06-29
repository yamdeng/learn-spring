package com.yamdeng.learn.spring.dto.request;

import com.yamdeng.learn.spring.dto.CommonRequestDTO;

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
public class UserRequestDTO extends CommonRequestDTO {

    private String name;

}
