package com.example.umc_exercise.domain;

import com.example.umc_exercise.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 20)
  private String name;

  @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
  List<MemberPrefer> memberPreferList = new ArrayList<>();


}
