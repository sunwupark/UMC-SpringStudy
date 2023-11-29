package com.example.umc_exercise.service.MissionService;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.converter.MissionConverter;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.MissionRequest;
import com.example.umc_exercise.dto.MissionResponse;
import com.example.umc_exercise.exception.handler.MissionHandler;
import com.example.umc_exercise.repository.MissionRepository;
import com.example.umc_exercise.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {
  private final MissionRepository missionRepository;
  private final StoreRepository storeRepository;

  @Transactional
  public MissionResponse.MissionRegisterResponseDTO register(MissionRequest.MissionRegisterRequestDTO missionRegisterRequestDTO) throws IOException {
    System.out.println("missionRegisterRequestDTO = " + missionRegisterRequestDTO.getMissionSpec());
    Store store = storeRepository.findById(missionRegisterRequestDTO.getShop_id()).orElseThrow(() -> new MissionHandler(ErrorStatus.STORE_MISSION_NOT_FOUND));
    Mission mission = missionRepository.save(MissionConverter.toMissionEntity(missionRegisterRequestDTO, store));
    return MissionConverter.missionRegisterResponseDTO(mission);
  }

  @Transactional
  public List<Mission> findAll(){
    return missionRepository.findAll();
  }
}
