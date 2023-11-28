package com.example.umc_exercise.service.TempService;

import com.example.umc_exercise.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
  @Override
  public void CheckFlag(Integer flag) {
    if (flag == 1)
      throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
  }
}
