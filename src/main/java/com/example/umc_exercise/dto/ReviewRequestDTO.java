package com.example.umc_exercise.dto;

import com.example.umc_exercise.validation.annotation.ExistMember;
import com.example.umc_exercise.validation.annotation.ExistStore;
import lombok.Getter;

public class ReviewRequestDTO {
  @Getter
  public static class addReview {
    @ExistStore
    Long store_id;

    String comment;
    String title;
    Float score;

    @ExistMember
    Long member_id;
  }
}
