package com.example.umc_exercise.service.MemberService;

import com.example.umc_exercise.domain.Member;

public interface MemberQueryService {
  public Member findById(Long id);
}
