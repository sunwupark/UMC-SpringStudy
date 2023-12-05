package com.example.umc_exercise.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class registerResponseDTO{
    Long memberMissionId;
    LocalDateTime createdAt;
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class toMissionCompleteResponseDTO{
    Long memberId;
    Long missionId;
  }

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionByMemberMissionResponseDTO {
    Long memberId;
    Long missionId;
  }

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MissionByMemberMissionResponseListDTO {
    List<MemberMissionResponseDTO.MissionByMemberMissionResponseDTO> memberMissionList;
    Integer listSize;
    Integer totalPage;
    Long totalElements;
    Boolean isFirst;
    Boolean isLast;
  }
}