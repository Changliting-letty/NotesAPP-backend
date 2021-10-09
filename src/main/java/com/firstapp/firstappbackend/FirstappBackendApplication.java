package com.firstapp.firstappbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.firstapp.firstappbackend")
public class FirstappBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstappBackendApplication.class, args);
    }

}
