package com.example.umc_exercise.exception.handler;


import com.example.umc_exercise.apiPayload.code.BaseErrorCode;
import com.example.umc_exercise.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
