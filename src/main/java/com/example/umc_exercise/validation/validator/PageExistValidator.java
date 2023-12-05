package com.example.umc_exercise.validation.validator;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.service.FoodCategoryService.FoodCategoryQueryService;
import com.example.umc_exercise.validation.annotation.CheckPage;
import com.example.umc_exercise.validation.annotation.ExistCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PageExistValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = true;

        if(value < 1){
            isValid = false;
        }
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_NOT_VALID.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
