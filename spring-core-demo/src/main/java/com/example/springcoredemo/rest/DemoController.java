package com.example.springcoredemo.rest;

import com.example.util.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //private field
    private Coach myCoach;

    @Autowired
    public void setCoach(@Qualifier("cricketCoach")Coach theCoach){
        System.out.println("In constructor : "+ getClass().getSimpleName());
        myCoach  = theCoach;
    }
    /*@Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
