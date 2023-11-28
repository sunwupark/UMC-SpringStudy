package com.example.umc_exercise.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "location")
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  String name;
}
