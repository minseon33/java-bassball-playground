package com.example.javabassballplayground.play;

import com.example.javabassballplayground.entity.Baseball;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class BaseballGame {
    Baseball baseball;
    Integer playerNumber;
    Integer baseballNumber;

    public BaseballGame(Baseball baseball) {
        this.baseball = baseball;
        this.baseballNumber = baseball.baseballNumber;
    }

    public BaseballGame(Integer baseballNumber) {
        this.baseball = new Baseball();
        this.baseballNumber = baseballNumber;
    }


    public String validateNumber(Integer playerNumber){
        this.playerNumber = playerNumber;
        int strike = 0;
        int ball = 0;
        ArrayList<Integer> playerNumberList= new ArrayList<>();
        ArrayList<Integer> baseballNumberList= new ArrayList<>();

        // 자리수 구하기
        ArrayList<Integer> playerNumberDigits = countDigits(playerNumber, playerNumberList);
        ArrayList<Integer> baseballNumberDigits = countDigits(baseballNumber, baseballNumberList);

        //해당 자리수에 숫자가 같은지 확인
        for (int i = 0; i < 3; i++) {
            if(playerNumberDigits.get(i)==baseballNumberDigits.get(i)){
                strike++;
            }
        }

        for (int i = 0; i < 3; i++) {
            ball += getBall(ball, playerNumberDigits, baseballNumberDigits, i);
        }

        
        // 정답 메세지 추출
        return createMassage(strike,ball);

    }

    /**
     * 자리수 구하기
     * @param number : baseballNumber or playerNumber
     * @param numberList
     * @return : numberList
     */
    private ArrayList<Integer> countDigits(Integer number, ArrayList<Integer> numberList) {
        while (number >0){
            numberList.add(number %10);
            number /=10;
        }
        return numberList;
    }

    /**
     * 자리수 별 볼 개수
     * @param ball
     * @param playerNumberDigits
     * @param baseballNumberDigits
     * @param i
     * @return
     */

    private int getBall(int ball, ArrayList<Integer> playerNumberDigits, ArrayList<Integer> baseballNumberDigits, int i) {
        if(i ==0){
            if(playerNumberDigits.get(i)== baseballNumberDigits.get(1)){
                ball++;
            } else if (playerNumberDigits.get(i)== baseballNumberDigits.get(2)) {
                ball++;
            }
        }
        if(i ==1){
            if(playerNumberDigits.get(i)== baseballNumberDigits.get(0)){
                ball++;
            } else if (playerNumberDigits.get(i)== baseballNumberDigits.get(2)) {
                ball++;

            }
        }
        if(i ==2){
            if(playerNumberDigits.get(i)== baseballNumberDigits.get(0)){
                ball++;
            } else if (playerNumberDigits.get(i)== baseballNumberDigits.get(1)) {
                ball++;

            }
        }
        return ball;
    }

    /**
     * 프린트 될 메세지
     * @param strike
     * @param ball
     * @return
     */

    private String createMassage(int strike, int ball){
        String massage = "";

        if(strike == 3){
            return "3개의 숫자를 모두 맞추셨습니다! 게임 종료";
        }
        if(strike==0 && ball == 0){
            return "모든 숫자가 틀렸습니다.(낫싱)";
        }
        if (strike!=0) {
            massage += strike + "스트라이크";
        }
        if (ball !=0) {
            massage += ball + "볼";
        }
        return massage;

    }

    /**
     * 게임 종료, 자원프리
     */

    public void endGame(){
        baseball = null;
        baseballNumber = null;
        playerNumber = null;

    }
}
