package com.example.umc_exercise.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 20)
  private String name;

  @Column(nullable = false, length = 256)
  private String address;

  private Float score;

  @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
  List<Mission> missionList = new ArrayList<>();

  @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
  List<Review> reviewList = new ArrayList<>();

  @OneToOne
  @JoinColumn(name = "location")
  private Location location;

}