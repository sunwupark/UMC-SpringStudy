package com.example.umc_exercise.repository;

import com.example.umc_exercise.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
