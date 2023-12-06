package com.example.umc_exercise.apiPayload.code;

public interface BaseErrorCode {
  public ErrorReasonDTO getReason();

  public ErrorReasonDTO getReasonHttpStatus();
}
