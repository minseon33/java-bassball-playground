package com.example.javabassballplayground.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 숫자가 생성이 된다.")
    @Test
    void createNumber() {
        //given
        Baseball baseball = new Baseball();

        //when
        Integer number = baseball.createNumber();

        //then
        Assertions.assertThat(number).isNotZero();
        System.out.println("숫자야구 생성된 숫자 : " + baseball.baseballNumber);
    }


}