package com.example.umc_exercise.service.MemberService;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.exception.handler.MemberHandler;
import com.example.umc_exercise.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

  private final MemberRepository memberRepository;
  @Override
  public Member findById(Long id) {
    return memberRepository.findById(id).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
  }
}
