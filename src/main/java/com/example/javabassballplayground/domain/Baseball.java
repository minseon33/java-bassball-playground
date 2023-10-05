package com.example.javabassballplayground.domain;

import com.example.javabassballplayground.enums.ErrorMessage;

import java.util.*;

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
            throw new IllegalArgumentException(ErrorMessage.BASEBALL_SIZE_ERROR.toString());
        }
    }

    private void validateSize(List<String> baseballNumber) {
        Set<String> nonDuplicateNumbers = new HashSet<>(baseballNumber);
        if(nonDuplicateNumbers.size() != BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.toString());
        }

    }

    /**
     * baseballNumber 조회하는 메서드
     * @return :: baseballNumber
     */
    public List<String> getBaseballNumber(){
        return baseballNumber;
    }

    /**
     * List<String> 으로 저장되어 있는 ballballNumber들을 3자리 int로 변환해주는 메서드
     * @param baseballNumber
     * @return
     */

    public int convertBaseballToInt(List<String> baseballNumber){
        String mergedBaseballNumber = "";
        for (int i = 0; i < baseballNumber.size(); i++) {
            mergedBaseballNumber += baseballNumber.get(i);
        }
        int convertedBaseballInt = Integer.parseInt(mergedBaseballNumber);
        return convertedBaseballInt;
    }
}
