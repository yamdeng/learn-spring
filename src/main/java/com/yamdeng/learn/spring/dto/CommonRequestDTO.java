package com.yamdeng.learn.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
abstract public class CommonRequestDTO {

    private int pageSize;
    private int currentPage;
    private String sortName;
    private String sortDirection;

}
