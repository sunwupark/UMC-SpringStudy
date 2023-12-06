package com.example.umc_exercise.exception.handler;


import com.example.umc_exercise.apiPayload.code.BaseErrorCode;
import com.example.umc_exercise.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
