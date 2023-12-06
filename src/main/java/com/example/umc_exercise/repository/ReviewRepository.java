package com.example.umc_exercise.repository;

import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.domain.Review;
import com.example.umc_exercise.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  Page<Review> findAllByStore(Store store, PageRequest pageRequest);

  Page<Review> findByMember(Member member, PageRequest pageRequest);
}
