package com.example.umc_exercise.repository;

import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

  @Query("select l from MemberMission l where l.member.id = :member and l.mission.id = :mission")
  public Optional<MemberMission> findMemberMissionByMemberAndMission(@Param("member") Long member, @Param("mission") Long mission);
}
