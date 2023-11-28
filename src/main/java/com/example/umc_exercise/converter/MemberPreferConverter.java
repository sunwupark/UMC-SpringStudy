package com.example.umc_exercise.converter;

import com.example.umc_exercise.domain.FoodCategory;
import com.example.umc_exercise.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

  public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

    return foodCategoryList.stream()
            .map(foodCategory ->
                    MemberPrefer.builder()
                            .foodCategory(foodCategory)
                            .build()
            ).collect(Collectors.toList());
  }
}

