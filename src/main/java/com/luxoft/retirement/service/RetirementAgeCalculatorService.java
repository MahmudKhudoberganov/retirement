package com.luxoft.retirement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RetirementAgeCalculatorService {

  public int calculateAge(int currentAge, int ageToRetire) {
    return ageToRetire - currentAge;
  }

}
