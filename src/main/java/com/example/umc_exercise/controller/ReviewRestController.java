package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.ReviewConverter;
import com.example.umc_exercise.converter.StoreConverter;
import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.ReviewRequestDTO;
import com.example.umc_exercise.dto.ReviewResponseDTO;
import com.example.umc_exercise.dto.StoreRequestDTO;
import com.example.umc_exercise.dto.StoreResponseDTO;
import com.example.umc_exercise.service.ReviewService.ReviewService;
import com.example.umc_exercise.service.StoreService.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {
  private final ReviewService reviewService;

  @PostMapping
  public ApiResponse<ReviewResponseDTO.addReviewResultDTO> registerReview(@RequestBody @Valid ReviewRequestDTO.addReview request) {
    Review review = reviewService.addReview(request);
    return ApiResponse.onSuccess(ReviewConverter.toaddReviewResultDTO(review));
  }

}
