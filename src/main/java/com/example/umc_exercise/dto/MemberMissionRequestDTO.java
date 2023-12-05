package com.example.umc_exercise.dto;

import com.example.umc_exercise.validation.annotation.ExistChallengingMissions;
import com.example.umc_exercise.validation.annotation.ExistMember;
import com.example.umc_exercise.validation.annotation.ExistMission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionRequestDTO {
  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @ExistChallengingMissions(message = "이미 도전 중인 미션입니다.", memberId = "memberId", missionId = "missionId")
  public static class registerMemberMissionDTO{
    Long memberId;
    Long missionId;
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class toMissionCompleteRequestDTO{
    @ExistMember
    Long memberId;

    @ExistMission
    Long missionId;
  }
}
