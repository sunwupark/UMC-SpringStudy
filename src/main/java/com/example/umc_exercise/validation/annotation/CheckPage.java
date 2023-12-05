package com.example.umc_exercise.validation.annotation;

import com.example.umc_exercise.validation.validator.PageExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

  String message() default "해당하는 페이지가 존재하지 않습니다.";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
