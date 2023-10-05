package com.example.javabassballplayground.enums;

import lombok.Builder;

public enum ErrorMessage {
    DUPLICATE_NUMBER_ERROR("중복된 숫자를 사용할 수 없습니다."),

    BASEBALL_SIZE_ERROR("숫자는 3자리 수여야 합니다.");
    private final String errorMessage;


    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
