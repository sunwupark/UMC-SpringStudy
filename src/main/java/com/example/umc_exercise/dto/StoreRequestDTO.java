package com.example.umc_exercise.dto;

import com.example.umc_exercise.domain.Location;
import com.example.umc_exercise.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {
  @Getter
  public static class JoinDTO{
    @NotBlank
    String name;
    @Size(min = 5, max = 12)
    String address;
    Float rating;
    Long location_id;
  }
}
