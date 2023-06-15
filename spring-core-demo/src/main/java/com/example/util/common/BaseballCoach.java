package com.example.util.common;

import org.springframework.stereotype.Component;

@Component //이제부터 이 클래스는 java bean이다.
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In construcotr: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Batting Practice for 30 minutes";
    }
}
