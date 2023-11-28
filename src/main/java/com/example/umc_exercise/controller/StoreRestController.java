package com.example.umc_exercise.controller;

import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.StoreRequestDTO;
import com.example.umc_exercise.service.StoreService.StoreService;
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
  public Long registerStore(@RequestBody @Valid StoreRequestDTO.JoinDTO request) {
    Store store = storeService.register(request);
    return store.getId();
  }

}
