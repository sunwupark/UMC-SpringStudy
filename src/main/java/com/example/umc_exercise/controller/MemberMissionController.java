package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.MemberMissionConverter;
import com.example.umc_exercise.dto.MemberMissionRequestDTO;
import com.example.umc_exercise.dto.MemberMissionResponseDTO;
import com.example.umc_exercise.service.MemberMissionService.MemberMissionService;
import com.example.umc_exercise.service.MemberService.MemberQueryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/missions")
public class MemberMissionController {
  private final MemberMissionService memberMissionService;

  @Operation(summary = "미션 등록하기 API",description = "미션을 멤버에 등록하는 API입니다")
  @PostMapping
  public ApiResponse<MemberMissionResponseDTO.registerResponseDTO> register(@RequestBody @Valid MemberMissionRequestDTO.registerMemberMissionDTO missionRegisterRequestDTO){
    return ApiResponse.onSuccess(MemberMissionConverter.toRegisterResponseDTO(memberMissionService.registerMission(missionRegisterRequestDTO)));
  }
  @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API",description = "진행중인 미션 진행 완료로 바꾸는 API입니다")
  @PostMapping("/complete")
  public ApiResponse<MemberMissionResponseDTO.toMissionCompleteResponseDTO> toMissionComplete(@RequestBody @Valid MemberMissionRequestDTO.toMissionCompleteRequestDTO missionCompleteRequestDTO){
    return ApiResponse.onSuccess(MemberMissionConverter.toMissionCompleteResponseDTO(memberMissionService.missionComplete(missionCompleteRequestDTO)));
  }



}
