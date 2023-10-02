package com.example.javabassballplayground;

import com.example.javabassballplayground.entity.Baseball;
import com.example.javabassballplayground.play.BaseballGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaBassballPlaygroundApplication {

    public static void main(String[] args) {
//        SpringApplication.run(JavaBassballPlaygroundApplication.class, args);
        Baseball baseball= new Baseball();
        BaseballGame baseballGame = new BaseballGame(baseball);
        Scanner sc = new Scanner(System.in);
        Integer playerNumber;
        int endGame = 0;

        while (endGame!=2){
            if(baseball.baseballNumber==null){
                baseball.createNumber();
            }
            System.out.println("숫자를 입력하세요");
            playerNumber = sc.nextInt();
            String validateMassage = baseballGame.validateNumber(playerNumber);
            System.out.println(validateMassage);

            if(validateMassage.equals("3개의 숫자를 모두 맞추셨습니다! 게임 종료")){
                System.out.println("게임을 계속하시려면 1, 종료하시려면 2를 입력해주세요.");
                endGame = sc.nextInt();

                if(endGame == 2){
                    baseballGame.endGame();
                }
            }
        }
    }

}
