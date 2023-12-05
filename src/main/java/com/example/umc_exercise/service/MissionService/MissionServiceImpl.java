package com.example.umc_exercise.service.MissionService;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.converter.MemberMissionConverter;
import com.example.umc_exercise.converter.MissionConverter;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.domain.mapping.MemberMission;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.exception.handler.MissionHandler;
import com.example.umc_exercise.repository.MemberMissionRepository;
import com.example.umc_exercise.repository.MissionRepository;
import com.example.umc_exercise.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService{
  private final MissionRepository missionRepository;
  private final StoreRepository storeRepository;
  private final MemberMissionRepository memberMissionRepository;
  @Override
  public Mission register(@RequestBody @Valid MissionRequest.MissionRegisterRequestDTO missionRegisterRequestDTO)  {
    Store store = storeRepository.findById(missionRegisterRequestDTO.getShop_id()).orElseThrow(() -> new MissionHandler(ErrorStatus.STORE_MISSION_NOT_FOUND));
    return missionRepository.save(MissionConverter.toMissionEntity(missionRegisterRequestDTO, store));
  }
  @Override
  public List<Mission> findAll(){
    return missionRepository.findAll();
  }
  @Override
  public Page<Mission> findByMember(Long memberId, Integer page) {
    List<MemberMission> memberId1 = memberMissionRepository.findByMemberId(memberId);
    List<Long> missionIdList = MemberMissionConverter.toMissionIdList(memberId1);
    return missionRepository.findByIdIn(missionIdList, PageRequest.of(page, 10));
  }

  @Override
  public Page<Mission> getMissionsByStore(Long storeId, Integer page) {
    Store store = storeRepository.findById(storeId).orElseThrow(() -> new MissionHandler(ErrorStatus.STORE_MISSION_NOT_FOUND));
    return missionRepository.findByStore(store, PageRequest.of(page, 10));
  }

}
