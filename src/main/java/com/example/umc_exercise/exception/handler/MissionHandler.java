package com.example.umc_exercise.exception.handler;


import com.example.umc_exercise.apiPayload.code.BaseErrorCode;
import com.example.umc_exercise.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
