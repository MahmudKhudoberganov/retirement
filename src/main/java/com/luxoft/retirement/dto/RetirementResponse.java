package com.luxoft.retirement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class RetirementResponse {

  private final int ageLeft;
  private final int yearToRetire;

}
