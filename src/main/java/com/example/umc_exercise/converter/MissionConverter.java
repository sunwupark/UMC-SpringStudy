package com.example.umc_exercise.converter;

import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.dto.MissionResponse;
import com.example.umc_exercise.dto.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

  public static MissionResponse.MissionByShopResponseDTO missionByShopResponseDTO(Mission mission){
    return MissionResponse.MissionByShopResponseDTO.builder()
            .id(mission.getId())
            .reward(mission.getReward())
            .deadline(mission.getDeadline())
            .missionSpec(mission.getMissionSpec())
            .storeId(mission.getStore().getId())
            .build();
  }

  public static MissionResponse.MissionByShopResponseListDTO missionByShopResponseListDTO(Page<Mission> missionList){
    List<MissionResponse.MissionByShopResponseDTO> missionByShopResponseDTOList = missionList.stream()
            .map(MissionConverter::missionByShopResponseDTO).collect(Collectors.toList());
    return MissionResponse.MissionByShopResponseListDTO.builder()
            .missionList(missionByShopResponseDTOList)
            .listSize(missionList.getSize())
            .totalPage(missionList.getTotalPages())
            .totalElements(missionList.getTotalElements())
            .isFirst(missionList.isFirst())
            .isLast(missionList.isLast())
            .build();
  }

}