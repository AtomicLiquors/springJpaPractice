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
    private Coach anotherCoach;

    @Autowired
    public void setCoach(@Qualifier("cricketCoach")Coach theCoach, @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor : "+ getClass().getSimpleName());
        myCoach  = theCoach;
        anotherCoach = theAnotherCoach;


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
