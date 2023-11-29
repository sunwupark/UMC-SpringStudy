package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.mapping.MemberMission;
import com.example.umc_exercise.dto.MemberMissionRequestDTO;
import com.example.umc_exercise.dto.MemberMissionResponseDTO;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.dto.MissionResponse;
import com.example.umc_exercise.service.MemberMissionService.MemberMissionService;
import com.example.umc_exercise.service.MissionService.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/missions")
public class MemberMissionController {
  private final MemberMissionService memberMissionService;

  @GetMapping
  public List<MemberMission> findAll(){
    return memberMissionService.findAll();
  }

  @PostMapping
  public ApiResponse<MemberMissionResponseDTO.registerResponseDTO> register(@RequestBody @Valid MemberMissionRequestDTO.registerMemberMissionDTO missionRegisterRequestDTO){
    return ApiResponse.onSuccess(memberMissionService.registerMission(missionRegisterRequestDTO));
  }

}
