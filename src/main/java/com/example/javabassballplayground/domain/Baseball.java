package com.example.javabassballplayground.domain;

import com.example.javabassballplayground.service.ErrorMessage;

import java.nio.channels.IllegalBlockingModeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {
//    public Integer baseballNumber;

    private static final int BASEBALL_NUMBER_SIZE = 3;
    private final List<String> baseballNumber;

    public Baseball(List<String> baseballNumber) {
        validateSize(baseballNumber);
        validateDuplicate(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateDuplicate(List<String> baseballNumber) {
        if(baseballNumber.size()!=BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.toString());
        }
    }

    private void validateSize(List<String> baseballNumber) {

    }
}
