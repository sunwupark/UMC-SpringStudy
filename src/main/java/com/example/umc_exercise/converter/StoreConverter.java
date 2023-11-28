package com.example.umc_exercise.converter;

import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.domain.enums.Gender;
import com.example.umc_exercise.dto.MemberRequestDTO;
import com.example.umc_exercise.dto.MemberResponseDTO;
import com.example.umc_exercise.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {

  public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
    return StoreResponseDTO.JoinResultDTO.builder()
            .store_id(store.getId())
            .createdAt(LocalDateTime.now())
            .build();
  }
}