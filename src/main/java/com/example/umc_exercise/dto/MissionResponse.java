package com.example.umc_exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class MissionResponse {

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionRegisterResponseDTO {
    Long review_id;
    LocalDateTime created_at;
  }

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionByShopResponseDTO {
      Long id;
      Integer reward;
      LocalDate deadline;
      String missionSpec;
      Long storeId;
  }

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionByShopResponseListDTO {
    List<MissionResponse.MissionByShopResponseDTO> missionList;
    Integer listSize;
    Integer totalPage;
    Long totalElements;
    Boolean isFirst;
    Boolean isLast;
  }

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionByMemberResponseDTO {
    Long id;
    Integer reward;
    LocalDate deadline;
    String missionSpec;
    Long storeId;
  }

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionByMemberResponseListDTO {
    List<MissionResponse.MissionByMemberResponseDTO> missionList;
    Integer listSize;
    Integer totalPage;
    Long totalElements;
    Boolean isFirst;
    Boolean isLast;
  }
}
