package com.example.umc_exercise.domain;

import com.example.umc_exercise.domain.common.BaseEntity;
import com.example.umc_exercise.domain.mapping.MemberMission;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer reward;

  private LocalDate deadline;

  @Column(nullable = false, length = 256)
  private String missionSpec;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;

  @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
  private List<MemberMission> memberMissionList = new ArrayList<>();
}