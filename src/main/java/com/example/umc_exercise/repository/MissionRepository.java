package com.example.umc_exercise.repository;

import com.example.umc_exercise.domain.Mission;
import com.example.umc_exercise.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
  Page<Mission> findByStore(Store store, PageRequest pageRequest);

  Page<Mission> findByIdIn(Iterable<Long> missionIdList, PageRequest pageRequest);
}
