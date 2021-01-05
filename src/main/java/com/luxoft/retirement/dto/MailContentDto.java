package com.luxoft.retirement.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailContentDto {

  private final int ageLeft;
  private final int currentYear;
  private final int yearToRetire;

}
