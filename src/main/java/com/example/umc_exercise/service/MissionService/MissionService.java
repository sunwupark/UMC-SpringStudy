package com.example.umc_exercise.service.MissionService;

import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.dto.MissionRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MissionService {
  public Mission register(MissionRequest.MissionRegisterRequestDTO missionRegisterRequestDTO);

  public Page<Mission> getMissionsByStore(Long storeId, Integer page);

  public List<Mission> findAll();

  public Page<Mission> findByMember(Long memberId, Integer page);
}
