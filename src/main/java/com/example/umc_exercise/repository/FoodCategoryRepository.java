package com.example.umc_exercise.repository;


import com.example.umc_exercise.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
