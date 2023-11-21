package com.example.umc_exercise.exception.handler;

import com.example.umc_exercise.apiPayload.code.BaseErrorCode;
import com.example.umc_exercise.exception.GeneralException;

public class TempHandler extends GeneralException {
  public TempHandler(BaseErrorCode errorCode){
    super(errorCode);
  }
}
