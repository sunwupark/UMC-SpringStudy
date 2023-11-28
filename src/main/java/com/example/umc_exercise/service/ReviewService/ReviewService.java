package com.example.umc_exercise.service.ReviewService;

import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.dto.ReviewRequestDTO;

public interface ReviewService {
  public Review addReview(ReviewRequestDTO.addReview review);
}
