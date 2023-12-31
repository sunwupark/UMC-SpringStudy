package com.example.umc_exercise.service.ReviewService;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.ReviewRequestDTO;
import com.example.umc_exercise.exception.handler.MemberHandler;
import com.example.umc_exercise.exception.handler.ReviewHandler;
import com.example.umc_exercise.exception.handler.StoreHandler;
import com.example.umc_exercise.repository.MemberRepository;
import com.example.umc_exercise.repository.ReviewRepository;
import com.example.umc_exercise.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository reviewRepository;
  private final StoreRepository storeRepository;
  private final MemberRepository memberRepository;

  @Override
  public Review addReview(ReviewRequestDTO.addReview request){
    Store store = storeRepository.findById(request.getStore_id()).orElseThrow(() -> new ReviewHandler(ErrorStatus.REVIEW_STORE_NOT_FOUND));
    Member member = memberRepository.findById(request.getMember_id()).orElseThrow(() -> new ReviewHandler(ErrorStatus.REVIEW_MEMBER_NOT_FOUND));
    Review review = Review.builder()
            .store(store)
            .member(member)
            .comment(request.getComment())
            .score(request.getScore())
            .title(request.getTitle())
            .build();
    return reviewRepository.save(review);
  }

  @Override
  public Page<Review> getReview(Long shop_id, Integer page){
    Store store = storeRepository.findById(shop_id).orElseThrow(() -> new StoreHandler(ErrorStatus.REVIEW_STORE_NOT_FOUND));
    return reviewRepository.findAllByStore(store, PageRequest.of(page,10));
  }

  @Override
  public Page<Review> getMyReview(Long member_id, Integer page){
    Member member = memberRepository.findById(member_id).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    return reviewRepository.findByMember(member, PageRequest.of(page, 10));
  }

}
