package com.example.umc_exercise.repository;

import com.example.umc_exercise.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
