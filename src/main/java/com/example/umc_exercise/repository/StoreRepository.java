package com.example.umc_exercise.repository;

import com.example.umc_exercise.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
