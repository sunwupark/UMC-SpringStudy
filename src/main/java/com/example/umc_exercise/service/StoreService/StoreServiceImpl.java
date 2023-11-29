package com.example.umc_exercise.service.StoreService;

import com.example.umc_exercise.apiPayload.code.status.ErrorStatus;
import com.example.umc_exercise.domain.Location;
import com.example.umc_exercise.domain.Store;
import com.example.umc_exercise.dto.StoreRequestDTO;
import com.example.umc_exercise.exception.handler.StoreHandler;
import com.example.umc_exercise.repository.LocationRepository;
import com.example.umc_exercise.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
  private final StoreRepository storeRepository;
  private final LocationRepository locationRepository;

  @Override
  public Store register(StoreRequestDTO.registerStore request){
    Location location = locationRepository.findById(request.getLocation_id()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_LOCATION_NOT_FOUND));
    System.out.println("location: " + location.getName());
    Store store = Store.builder()
            .address(request.getAddress())
            .score(request.getRating())
            .name(request.getName())
            .location(location)
            .build();
    return storeRepository.save(store);
  }
}
