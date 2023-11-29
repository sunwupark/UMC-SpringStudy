package com.example.umc_exercise.domain;

import com.example.umc_exercise.domain.common.BaseEntity;
import com.example.umc_exercise.domain.mapping.MemberAgree;
import jakarta.persistence.*;
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
public class Terms extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 256)
  private String body;

  private Boolean optional;

  @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
  private List<MemberAgree> memberAgreeList = new ArrayList<>();
}