package com.example.umc_exercise.validation.validator;

import com.example.umc_exercise.repository.LocationRepository;
import com.example.umc_exercise.validation.annotation.ExistLocation;
import javax.validation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;

@Component
@RequiredArgsConstructor
public class LocationExistValidator implements ConstraintValidator<ExistLocation, Long> {

    private final LocationRepository locationRepository;

    @Override
    public void initialize(ExistLocation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = locationRepository.existsById(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_LOCATION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }

}
