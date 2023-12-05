package com.example.umc_exercise.validation.validator;


import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.repository.MemberRepository;
import com.example.umc_exercise.repository.MissionRepository;
import com.example.umc_exercise.validation.annotation.ExistMember;
import com.example.umc_exercise.validation.annotation.ExistMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission,Long> {

    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionRepository.existsById(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
