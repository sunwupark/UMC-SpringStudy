package com.example.umc_exercise.converter;

import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.ReviewRequestDTO;
import com.example.umc_exercise.dto.ReviewResponseDTO;
import com.example.umc_exercise.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

  public static ReviewResponseDTO.addReviewResultDTO toaddReviewResultDTO(Review review){
    return ReviewResponseDTO.addReviewResultDTO.builder()
            .review_id(review.getId())
            .created_at(LocalDateTime.now())
            .build();
  }

  public static Review toReview(ReviewRequestDTO.addReview request){
    return Review.builder()
            .title(request.getTitle())
            .score(request.getScore())
            .comment(request.getComment())
            .build();
  }

  public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
    List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
            .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());
    return ReviewResponseDTO.ReviewPreViewListDTO.builder()
            .isLast(reviewList.isLast())
            .isFirst(reviewList.isFirst())
            .totalPage(reviewList.getTotalPages())
            .totalElements(reviewList.getTotalElements())
            .listSize(reviewPreViewDTOList.size())
            .reviewList(reviewPreViewDTOList)
            .build();
  }

  public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
    return ReviewResponseDTO.ReviewPreViewDTO.builder()
            .body(review.getComment())
            .createdAt(review.getCreatedAt().toLocalDate())
            .score(review.getScore())
            .ownerNickname(review.getMember().getName())
            .build();
  }
}