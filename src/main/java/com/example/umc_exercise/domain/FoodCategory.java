package com.example.umc_exercise.domain;

import com.example.umc_exercise.domain.mapping.MemberPrefer;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
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
