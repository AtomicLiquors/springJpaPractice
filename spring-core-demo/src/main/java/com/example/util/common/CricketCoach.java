package com.example.util.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component //이제부터 이 클래스는 java bean이다.
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In construcotr: " + getClass().getSimpleName());
    }

    //init method



    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes wwww";
    }
}
