package com.example.javabassballplayground.entity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Random;

public class Baseball {
    public Integer baseballNumber;
    private String firstNumber;
    private String secondNumber;
    private String thirdNumber;

    Random random = new Random();

    public Integer createNumber(){
        //첫번째 자리수 생성
        while (firstNumber==null){
            firstNumber = String.valueOf(random.nextInt(10));
            if(firstNumber.equals("0")){
                firstNumber = null;
            }
        }

        //두번째 자리 수 생성
        while (secondNumber==null || firstNumber.equals(secondNumber)){
            secondNumber = String.valueOf(random.nextInt(10));
            if(secondNumber.equals("0")){
                secondNumber = null;
            }
        }

        //세번째 자리 수 생성
        while (thirdNumber==null || firstNumber.equals(thirdNumber)|| secondNumber.equals(thirdNumber)){
            thirdNumber = String.valueOf(random.nextInt(10));
            if(thirdNumber.equals("0")){
                thirdNumber = null;
            }
        }
        //최종 숫자야구 숫자 저장
        String resultNumber = firstNumber+secondNumber+thirdNumber;
        baseballNumber = Integer.parseInt(resultNumber);
        return baseballNumber;
    }

}
