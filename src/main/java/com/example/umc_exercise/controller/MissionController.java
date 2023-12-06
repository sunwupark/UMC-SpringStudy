package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.MissionConverter;
import com.example.umc_exercise.converter.ReviewConverter;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.mapping.MemberMission;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.dto.MissionResponse;
import com.example.umc_exercise.service.MemberMissionService.MemberMissionService;
import com.example.umc_exercise.service.MissionService.MissionService;
import com.example.umc_exercise.service.MissionService.MissionServiceImpl;
import com.example.umc_exercise.validation.annotation.CheckPage;
import com.example.umc_exercise.validation.annotation.ExistMember;
import com.example.umc_exercise.validation.annotation.ExistStore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionController {
  private final MissionService missionService;

  @Operation(summary = "모든 미션 조회 API", description = "미션 조회 API")
  @GetMapping
  public List<Mission> findAll(){
    return missionService.findAll();
  }

  @Operation(summary = "가게에 미션 등록 API", description = "가게에 미션 등록 API")
  @PostMapping
  public ApiResponse<MissionResponse.MissionRegisterResponseDTO> register(@RequestBody @Valid MissionRequest.MissionRegisterRequestDTO missionRegisterRequestDTO) {
    return ApiResponse.onSuccess(MissionConverter.missionRegisterResponseDTO(missionService.register(missionRegisterRequestDTO)));
  }

  @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
  @GetMapping("/{storeId}/store")
  @Parameters({
          @Parameter(name = "storeId", description = "가게 아이디, path variable 입니다!"),
          @Parameter(name = "page", description = "페이지 번호, 1 페이지 부터입니다."),
  })
  public ApiResponse<MissionResponse.MissionByShopResponseListDTO> getShopReviews(@ExistStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
    if(page >= 1) {page -= 1;}
    return ApiResponse.onSuccess(MissionConverter.missionByShopResponseListDTO(missionService.getMissionsByStore(storeId, page)));
  }

  @Operation(summary = "나의 미션 목록 조회 API",description = "나의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
  @GetMapping("/{memberId}/member")
  @Parameters({
          @Parameter(name = "memberId", description = "가게 아이디, path variable 입니다!"),
          @Parameter(name = "page", description = "페이지 번호, 1 페이지 부터입니다."),
  })
  public ApiResponse<MissionResponse.MissionByShopResponseListDTO> getMyMissions (@ExistMember @PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
    if(page >= 1) {page -= 1;}
    return ApiResponse.onSuccess(MissionConverter.missionByShopResponseListDTO(missionService.findByMember(memberId, page)));
  }

}
