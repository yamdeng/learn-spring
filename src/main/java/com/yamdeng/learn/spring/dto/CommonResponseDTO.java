package com.yamdeng.learn.spring.dto;

import java.util.Collections;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class CommonResponseDTO<T> {

    @Builder.Default
    private List<T> list = Collections.emptyList();

    private int totalCount;
    private T detailInfo;

    @Builder.Default
    private boolean success = true;

}
