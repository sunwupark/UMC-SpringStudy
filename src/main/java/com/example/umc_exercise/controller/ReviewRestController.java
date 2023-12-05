package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.ReviewConverter;
import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.dto.ReviewRequestDTO;
import com.example.umc_exercise.dto.ReviewResponseDTO;
import com.example.umc_exercise.service.ReviewService.ReviewService;
import com.example.umc_exercise.validation.annotation.CheckPage;
import com.example.umc_exercise.validation.annotation.ExistMember;
import com.example.umc_exercise.validation.annotation.ExistStore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/review")
public class ReviewRestController {
  private final ReviewService reviewService;

  @Operation(summary = "리뷰 등록 API", description = "리뷰 등록 API이며")
  @PostMapping
  public ApiResponse<ReviewResponseDTO.addReviewResultDTO> registerReview(@RequestBody @Valid ReviewRequestDTO.addReview request) {
    Review review = reviewService.addReview(request);
    return ApiResponse.onSuccess(ReviewConverter.toaddReviewResultDTO(review));
  }

  @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
  @GetMapping("/{storeId}/store")
  @Parameters({
          @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
          @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
  })
  public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviews(@ExistStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam Integer page){
    Page<Review> review = reviewService.getReview(storeId, page);
    return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(review));
  }

  @Operation(summary = "내가 쓴 리뷰 목록 조회 API",description = "내가 쓴 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
  @GetMapping("/{memberId}/member")
  @Parameters({
          @Parameter(name = "memberId", description = "나의 아이디, path variable 입니다!"),
          @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
  })
  public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getMyReviews(@ExistMember @PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
    if(page > 1){
      page -= 1;
    }
    Page<Review> review = reviewService.getMyReview(memberId, page);
    return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(review));
  }
}
