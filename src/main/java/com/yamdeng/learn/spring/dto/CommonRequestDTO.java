package com.yamdeng.learn.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CommonRequestDTO {

    @Builder.Default
    private int offset = 0;
    @Builder.Default
    private int pageSize = 100000;
    @Builder.Default
    private int currentPage = 1;
    private String sortName;
    private String sortDirection;

}
