package com.example.umc_exercise.service.FoodCategoryService;

import com.example.umc_exercise.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {
  private final FoodCategoryRepository foodCategoryRepository;

  @Transactional
  public boolean existsById(List<Long> values){
    return values.stream()
            .allMatch(foodCategoryRepository::existsById);
  }
}
