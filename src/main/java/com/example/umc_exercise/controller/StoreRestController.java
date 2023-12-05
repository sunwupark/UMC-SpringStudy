package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.ReviewConverter;
import com.example.umc_exercise.converter.StoreConverter;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.dto.ReviewResponseDTO;
import com.example.umc_exercise.dto.StoreRequestDTO;
import com.example.umc_exercise.dto.StoreResponseDTO;
import com.example.umc_exercise.service.StoreService.StoreService;

import com.example.umc_exercise.validation.annotation.CheckPage;
import com.example.umc_exercise.validation.annotation.ExistMember;
import com.example.umc_exercise.validation.annotation.ExistStore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
  private final StoreService storeService;

  @Operation(summary = "가게 등록 API", description = "가게 등록 API이며")
  @PostMapping
  public ApiResponse<StoreResponseDTO.JoinResultDTO> registerStore(@RequestBody @Valid StoreRequestDTO.registerStore request) {
    return ApiResponse.onSuccess(StoreConverter.toRegisterRPDTO(storeService.register(request)));
  }
}
