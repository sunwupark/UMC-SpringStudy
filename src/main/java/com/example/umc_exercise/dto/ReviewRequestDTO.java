package com.example.umc_exercise.dto;

import lombok.Getter;

public class ReviewRequestDTO {
  @Getter
  public static class addReview{
    Long store_id;
    String comment;
    String title;

    Float score;

    Long member_id;

  }
}
