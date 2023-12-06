package com.example.umc_exercise.domain.mapping;

import com.example.umc_exercise.domain.FoodCategory;
import com.example.umc_exercise.domain.Member;
import com.example.umc_exercise.domain.common.BaseEntity;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private FoodCategory foodCategory;

  public void setMember(Member member){
    if(this.member != null)
      member.getMemberPreferList().remove(this);
    this.member = member;
    member.getMemberPreferList().add(this);
  }

  public void setFoodCategory(FoodCategory foodCategory){
    this.foodCategory = foodCategory;
  }

}