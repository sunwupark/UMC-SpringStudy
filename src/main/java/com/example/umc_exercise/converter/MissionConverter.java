package com.example.umc_exercise.converter;

import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.dto.MissionResponse;

import java.time.LocalDateTime;

public class MissionConverter{
  public static Mission toMissionEntity(MissionRequest.MissionRegisterRequestDTO missionRegisterRequestDTO, Store store){
    return Mission.builder()
            .missionSpec(missionRegisterRequestDTO.getMissionSpec())
            .deadline(missionRegisterRequestDTO.getDeadline())
            .reward(missionRegisterRequestDTO.getReward())
            .store(store)
            .build();
  }

  public static MissionResponse.MissionRegisterResponseDTO missionRegisterResponseDTO(Mission mission){
    return MissionResponse.MissionRegisterResponseDTO.builder()
            .review_id(mission.getId())
            .created_at(mission.getCreatedAt()).build();
  }

}