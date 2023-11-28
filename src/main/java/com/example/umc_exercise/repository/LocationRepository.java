package com.example.umc_exercise.repository;

import com.example.umc_exercise.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Long> {

  @Query("select l.id from Location l where l.name = :name")
  public Location findByName(@Param("name") String name);

}
