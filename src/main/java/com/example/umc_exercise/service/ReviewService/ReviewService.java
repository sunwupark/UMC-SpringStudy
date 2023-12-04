package com.example.umc_exercise.service.ReviewService;

import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.dto.ReviewRequestDTO;
import org.springframework.data.domain.Page;

public interface ReviewService {
  public Review addReview(ReviewRequestDTO.addReview review);

  public Page<Review> getReview(Long shop_id, Integer page);
}
