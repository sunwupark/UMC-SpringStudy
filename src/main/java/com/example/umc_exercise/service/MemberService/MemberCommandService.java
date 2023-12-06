package com.example.umc_exercise.service.MemberService;


import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
