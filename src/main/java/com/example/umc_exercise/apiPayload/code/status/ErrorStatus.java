package com.example.umc_exercise.apiPayload.code.status;

import com.example.umc_exercise.apiPayload.code.BaseErrorCode;
import com.example.umc_exercise.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
  _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의"),
  _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
  _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
  _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

  MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
  NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

  ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),
  // Ror test
  TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

  // FoodCategory Error
  FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD_CATEGORY4001", "음식 카테고리가 없습니다."),

  // Store Error
  STORE_LOCATION_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4004", "가게의 위치가 존재하지 않습니다"),
  STORE_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4005", "가게가 존재하지 않습니다"),
  STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4006", "가게가 존재하지 않습니다"),

  // Review ERROR
  REVIEW_STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW4004", "리뷰 대상 가게가 존재하지 않습니다"),
  REVIEW_MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW4005", "리뷰 대상 멤버가 존재하지 않습니다"),

  // Mission Error
  MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4004", "미션이 존재하지 않습니다"),
  MISSION_CHALLENGING(HttpStatus.BAD_REQUEST, "MISSION4005", "미션은 진행중인 상태입니다");

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;
  @Override
  public ErrorReasonDTO getReason() {
    return ErrorReasonDTO.builder()
            .message(message)
            .code(code)
            .isSuccess(false)
            .build();
  }

  @Override
  public ErrorReasonDTO getReasonHttpStatus() {
    return ErrorReasonDTO.builder()
            .message(message)
            .code(code)
            .isSuccess(false)
            .httpStatus(httpStatus)
            .build();
  }
}
