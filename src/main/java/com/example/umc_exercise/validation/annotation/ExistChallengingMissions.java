package com.example.umc_exercise.validation.annotation;

import com.example.umc_exercise.validation.validator.MemberMissionExistValidator;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistChallengingMissions {

  String message() default "해당하는 미션이 이미 도전중입니다";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  String memberId();

  String missionId();
}
