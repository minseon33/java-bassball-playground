package com.example.javabassballplayground.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BaseballServiceTest {

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 숫자가 생성이 된다.")
    @Test
    void generateNumber() {
        //given
        BaseballService baseball = new BaseballService();

        //when
        List<String> number = baseball.generateNumber();


        //then
        Assertions.assertThat(number).hasSize(3);
        System.out.println("숫자야구 생성된 숫자 : " + BaseballService.baseball.toString());
    }

}