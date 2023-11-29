package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.StoreConverter;
import com.example.umc_exercise.dto.StoreRequestDTO;
import com.example.umc_exercise.dto.StoreResponseDTO;
import com.example.umc_exercise.service.StoreService.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
  private final StoreService storeService;

  @PostMapping
  public ApiResponse<StoreResponseDTO.JoinResultDTO> registerStore(@RequestBody @Valid StoreRequestDTO.registerStore request) {
    return ApiResponse.onSuccess(StoreConverter.toRegisterRPDTO(storeService.register(request)));
  }

}
