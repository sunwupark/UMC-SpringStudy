package com.example.umc_exercise.dto;

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
    private Long shop_id;
  }

}
