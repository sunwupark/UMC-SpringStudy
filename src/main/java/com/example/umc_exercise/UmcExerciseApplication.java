package com.example.umc_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UmcExerciseApplication {

  public static void main(String[] args) {
    SpringApplication.run(UmcExerciseApplication.class, args);
  }

}
