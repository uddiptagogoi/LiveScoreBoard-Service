package com.LiveScoreBoardService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LiveScoreBoardService {

    public static void main(String[] args) {
        SpringApplication.run(LiveScoreBoardService.class, args);
    }

}
