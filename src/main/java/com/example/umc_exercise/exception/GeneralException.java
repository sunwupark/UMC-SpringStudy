package com.example.umc_exercise.exception;

import com.example.umc_exercise.apiPayload.code.BaseErrorCode;
import com.example.umc_exercise.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
  private BaseErrorCode code;
  public ErrorReasonDTO getErrorReason(){
    return this.code.getReason();
  }

  public ErrorReasonDTO getErrorReasonHttpStatus(){
    return this.code.getReasonHttpStatus();
  }
}
