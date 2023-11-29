package com.example.umc_exercise.dto;

import com.example.umc_exercise.validation.annotation.ExistStore;
import lombok.*;

import java.time.LocalDate;


public class MissionRequest {

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionRegisterRequestDTO {
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
    @ExistStore
    private Long shop_id;
  }

}
