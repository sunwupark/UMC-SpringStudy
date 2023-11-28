package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.StoreConverter;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.StoreRequestDTO;
import com.example.umc_exercise.dto.StoreResponseDTO;
import com.example.umc_exercise.service.StoreService.StoreService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
  private final StoreService storeService;

  @PostMapping
  public ApiResponse<StoreResponseDTO.JoinResultDTO> registerStore(@RequestBody StoreRequestDTO.JoinDTO request) {
    Store store = storeService.register(request);
    return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
  }

}
