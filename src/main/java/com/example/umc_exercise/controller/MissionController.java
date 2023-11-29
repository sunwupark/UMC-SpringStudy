package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.dto.MissionResponse;
import com.example.umc_exercise.service.MissionService.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
  private final MissionService missionService;

  @GetMapping
  public List<Mission> findAll(){
    return missionService.findAll();
  }

  @PostMapping
  public ApiResponse<MissionResponse.MissionRegisterResponseDTO> register(@RequestBody MissionRequest.MissionRegisterRequestDTO missionRegisterRequestDTO) throws IOException {
    return ApiResponse.onSuccess(missionService.register(missionRegisterRequestDTO));
  }

}
