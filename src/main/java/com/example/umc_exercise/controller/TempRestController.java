package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.TempConverter;
import com.example.umc_exercise.dto.TempResponse;
import com.example.umc_exercise.service.TempService.TempQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

  private final TempQueryService tempQueryService;
  @GetMapping("/test")
  public ApiResponse<TempResponse.TempTestDTO> testAPI() {
    return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
  }

  @GetMapping("/exception")
  public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag) {
    tempQueryService.CheckFlag(flag);
    return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
  }
}
