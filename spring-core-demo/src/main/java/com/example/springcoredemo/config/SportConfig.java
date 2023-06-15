package com.example.springcoredemo.config;

import com.example.util.common.Coach;
import com.example.util.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("seal") //bean Id
    public Coach swimCoach(){
        return new SwimCoach();
    }

    //@Component 어노테이션이 아닌 별도의 Configuration 클래스로 특정 클래스를 Bean으로 설정하는 방법.
}
