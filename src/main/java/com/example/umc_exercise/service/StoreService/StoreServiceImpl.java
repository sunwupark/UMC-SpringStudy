package com.example.umc_exercise.service.StoreService;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.domain.Location;
import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.StoreRequestDTO;
import com.example.umc_exercise.exception.handler.StoreHandler;
import com.example.umc_exercise.repository.LocationRepository;
import com.example.umc_exercise.repository.MissionRepository;
import com.example.umc_exercise.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
  private final StoreRepository storeRepository;
  private final LocationRepository locationRepository;
  private final MissionRepository missionRepository;

  @Override
  public Store register(StoreRequestDTO.registerStore request){
    Location location = locationRepository.findById(request.getLocation_id()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_LOCATION_NOT_FOUND));
    Store store = Store.builder()
            .address(request.getAddress())
            .score(request.getRating())
            .name(request.getName())
            .location(location)
            .build();
    return storeRepository.save(store);
  }
}
