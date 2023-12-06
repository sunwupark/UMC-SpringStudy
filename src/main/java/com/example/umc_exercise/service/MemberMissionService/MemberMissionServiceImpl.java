package com.example.umc_exercise.service.MemberMissionService;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.converter.MemberMissionConverter;
import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.enums.MissionStatus;
import com.example.umc_exercise.domain.mapping.MemberMission;
import com.example.umc_exercise.dto.MemberMissionRequestDTO;
import com.example.umc_exercise.exception.handler.MemberHandler;
import com.example.umc_exercise.exception.handler.MemberMissionHandler;
import com.example.umc_exercise.exception.handler.MissionHandler;
import com.example.umc_exercise.repository.MemberMissionRepository;
import com.example.umc_exercise.repository.MemberRepository;
import com.example.umc_exercise.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionServiceImpl implements MemberMissionService{
  private final MemberMissionRepository memberMissionRepository;
  private final MemberRepository memberRepository;
  private final MissionRepository missionRepository;;

  @Override
  public List<MemberMission> findAll(){
    return memberMissionRepository.findAll();
  }
  @Override
  public Optional<MemberMission> findByMissionIdAndMemberId(Long MissionId, Long MemberId) {
    return memberMissionRepository.findMemberMissionByMemberAndMission(MissionId, MemberId);
  }

  @Override
  public MemberMission missionComplete(MemberMissionRequestDTO.toMissionCompleteRequestDTO missionCompleteRequestDTO) {
    Member member = memberRepository.findById(missionCompleteRequestDTO.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    Mission mission = missionRepository.findById(missionCompleteRequestDTO.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
    return memberMissionRepository.findMemberMissionByMemberAndMission(mission.getId(), member.getId())
            .map(memberMission -> {
              memberMission.setStatus(MissionStatus.COMPLETE);
              return memberMissionRepository.save(memberMission);
            })
            .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));
  }

  @Override
  public Optional<MemberMission> findById(Long id){
    return memberMissionRepository.findById(id);
  }

  @Override
  public MemberMission registerMission(MemberMissionRequestDTO.registerMemberMissionDTO memberMissionRequestDTO){
    Member member = memberRepository.findById(memberMissionRequestDTO.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    Mission mission = missionRepository.findById(memberMissionRequestDTO.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

    MemberMission memberMission = MemberMissionConverter.toMemberMissionEntity(mission, member);

    return memberMissionRepository.save(memberMission);
  }
}
