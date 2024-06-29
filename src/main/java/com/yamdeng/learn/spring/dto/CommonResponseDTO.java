package com.yamdeng.learn.spring.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class CommonResponseDTO<T> {

    private int totalCount;
    private T data;

    @Builder.Default
    private boolean success = true;

    private String errorMessage;
    private String responseCode;

    public static CommonResponseDTO<?> getDefaultResponse() {
        return CommonResponseDTO.builder().build();
    }

}
