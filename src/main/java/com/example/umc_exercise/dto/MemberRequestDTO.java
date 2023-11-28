package com.example.umc_exercise.dto;

import com.example.umc_exercise.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

  @Getter
  public static class JoinDto{
    @NotBlank
    String name;
    @NotBlank
    String email;
    @NotNull
    Integer gender;
    @NotNull
    Integer birthYear;
    @NotNull
    Integer birthMonth;
    @NotNull
    Integer birthDay;
    @Size(min = 5, max = 12)
    String address;
    @Size(min = 5, max = 12)
    String specAddress;
    @ExistCategories
    List<Long> preferCategory;
  }
}