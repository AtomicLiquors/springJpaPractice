package com.example.util.common;

import org.springframework.stereotype.Component;

@Component //이제부터 이 클래스는 java bean이다.
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes wwww";
    }
}
