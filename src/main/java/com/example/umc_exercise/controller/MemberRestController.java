package com.example.umc_exercise.controller;

import com.example.umc_exercise.apiPayload.ApiResponse;
import com.example.umc_exercise.converter.MemberConverter;
import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.dto.*;
import com.example.umc_exercise.service.MemberService.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

  private final MemberCommandService memberCommandService;

  @PostMapping("/")
  public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
    Member member = memberCommandService.joinMember(request);
    return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
  }
}
