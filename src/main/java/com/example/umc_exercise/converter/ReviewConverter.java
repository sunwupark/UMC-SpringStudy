package com.example.umc_exercise.converter;

import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.ReviewResponseDTO;
import com.example.umc_exercise.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

  public static ReviewResponseDTO.addReviewResultDTO toaddReviewResultDTO(Review review){
    return ReviewResponseDTO.addReviewResultDTO.builder()
            .review_id(review.getId())
            .created_at(LocalDateTime.now())
            .build();
  }
}