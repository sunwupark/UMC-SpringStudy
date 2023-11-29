package com.example.umc_exercise.validation.validator;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.domain.enums.MissionStatus;
import com.example.umc_exercise.domain.mapping.MemberMission;
import com.example.umc_exercise.service.FoodCategoryService.FoodCategoryQueryService;
import com.example.umc_exercise.service.MemberMissionService.MemberMissionService;
import com.example.umc_exercise.validation.annotation.ExistCategories;
import com.example.umc_exercise.validation.annotation.ExistChallengingMissions;
import javax.validation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerErrorException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistChallengingMissions, Object> {

    private final MemberMissionService memberMissionService;
    private String missionId;
    private String memberId;

    @Override
    public void initialize(ExistChallengingMissions constraintAnnotation) {
        missionId = constraintAnnotation.missionId();
        memberId = constraintAnnotation.memberId();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {

        Long member_id = getFieldValue(o, memberId);
        Long mission_id = getFieldValue(o, missionId);

        Optional<MemberMission> memberMission = memberMissionService.findByMissionIdAndMemberId(mission_id, member_id);
        if(memberMission.isEmpty()) {
            return true;
        }
        if (memberMission.get().getStatus() == MissionStatus.CHALLENGING) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_CHALLENGING.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }

    private Long getFieldValue(Object object, String fieldName) throws ServerErrorException {
        Class<?> clazz = object.getClass();
        Field dateField;
        try {
            dateField = clazz.getDeclaredField(fieldName);
            dateField.setAccessible(true);
            Object target = dateField.get(object);
            if (!(target instanceof Long)) {
                throw new ClassCastException("casting exception");
            }
            return (Long) target;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }
}
