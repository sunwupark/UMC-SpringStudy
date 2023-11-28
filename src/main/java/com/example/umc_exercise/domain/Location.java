package com.example.umc_exercise.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "location")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  String name;
}
