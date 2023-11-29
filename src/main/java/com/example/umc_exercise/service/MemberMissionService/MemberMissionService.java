package com.example.umc_exercise.service.MemberMissionService;

import com.example.umc_exercise.domain.mapping.MemberMission;
import com.example.umc_exercise.dto.MemberMissionRequestDTO;
import com.example.umc_exercise.dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MemberMissionService {
  public MemberMissionResponseDTO.registerResponseDTO registerMission(MemberMissionRequestDTO.registerMemberMissionDTO memberMissionRequestDTO);
  public List<MemberMission> findAll();

  public Optional<MemberMission> findByMissionIdAndMemberId(Long MissionId, Long MemberId);

}
