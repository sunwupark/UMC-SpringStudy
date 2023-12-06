package com.example.umc_exercise.converter;

import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.domain.enums.MissionStatus;
import com.example.umc_exercise.domain.mapping.MemberMission;
import com.example.umc_exercise.dto.MemberMissionRequestDTO;
import com.example.umc_exercise.dto.MemberMissionResponseDTO;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.dto.MissionResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
  public static MemberMission toMemberMissionEntity(Mission mission, Member member){
    return MemberMission.builder()
            .member(member)
            .mission(mission)
            .status(MissionStatus.CHALLENGING)
            .build();
  }

  public static MemberMissionResponseDTO.registerResponseDTO toRegisterResponseDTO(MemberMission memberMission){
    return MemberMissionResponseDTO.registerResponseDTO.builder()
            .memberMissionId(memberMission.getId())
            .createdAt(memberMission.getCreatedAt()).build();
  }

  public static List<Long> toMissionIdList(List<MemberMission> memberMissionList){
    return memberMissionList.stream().map(memberMission -> memberMission.getMission().getId()).collect(Collectors.toList());
  }

  public static MemberMissionResponseDTO.toMissionCompleteResponseDTO toMissionCompleteResponseDTO(MemberMission save) {
    return MemberMissionResponseDTO.toMissionCompleteResponseDTO.builder()
            .memberId(save.getMember().getId())
            .missionId(save.getMission().getId())
            .build();
  }
}