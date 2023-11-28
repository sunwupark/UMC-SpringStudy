package com.example.umc_exercise.service.StoreService;

import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.StoreRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface StoreService {
  public Store register(@RequestBody StoreRequestDTO.JoinDTO request);
}
