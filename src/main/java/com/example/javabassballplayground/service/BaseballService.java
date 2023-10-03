package com.example.javabassballplayground.service;

import java.util.ArrayList;
import java.util.Random;

public class BaseballService {

    public static ArrayList<String> baseballNumber = new ArrayList<>();
    private String hundredsDigit;
    private String tensDigit;
    private String onesDigit;
    Random random = new Random();



    public ArrayList<String> createNumber(){
        //백의자리수 번호 생성
        baseballNumber.add(hundredsDigit = determineDigitNumber(hundredsDigit,tensDigit,onesDigit));

        //십의 자리수 번호 생성
        baseballNumber.add(tensDigit = determineDigitNumber(tensDigit,hundredsDigit,onesDigit));

        //일의 자리수 번호 생성
        baseballNumber.add(onesDigit = determineDigitNumber(onesDigit,tensDigit,hundredsDigit));

        //최종 숫자야구 숫자 저장
        return baseballNumber;
    }

    private String determineDigitNumber(String targetDigit,String comparisonFirst, String comparisonSecond) {
        while (targetDigit ==null){
            //랜덤으로 숫자 지정
            targetDigit = String.valueOf(random.nextInt(10));
            //다른 자리수의 번호랑 같은지 안같은지 확인하는 메서드
            targetDigit = verifyDuplicateDigitNumber(targetDigit,comparisonFirst,comparisonSecond);
            //0은 제외해야 함.
            targetDigit = excludeZeros(targetDigit);
        }
        return targetDigit;
    }

    private String verifyDuplicateDigitNumber(String targetDigit,String comparisonFirst, String comparisonSecond) {
        if(targetDigit.equals(comparisonFirst)||targetDigit.equals(comparisonSecond)){
            return  null;
        }
        return targetDigit;
    }

    private String excludeZeros(String numberOfDigits) {
        if (numberOfDigits == null || numberOfDigits.equals("0")) {
            return null;
        }
        return numberOfDigits;
    }
}
