package com.example.umc_exercise.dto;

import com.example.umc_exercise.domain.Location;
import com.example.umc_exercise.validation.annotation.ExistCategories;
import com.example.umc_exercise.validation.annotation.ExistLocation;
import com.example.umc_exercise.validation.annotation.ExistStore;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class StoreRequestDTO {
  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class registerStore{
    @NotBlank
    String name;
    @Size(min = 5, max = 12)
    String address;
    Float rating;
    @ExistLocation
    Long location_id;
  }
}
