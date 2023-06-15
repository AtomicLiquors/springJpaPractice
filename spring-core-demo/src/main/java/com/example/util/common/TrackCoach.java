package com.example.util.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component //이제부터 이 클래스는 java bean이다.
@Lazy
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("In construcotr: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }
}
