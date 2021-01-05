package com.luxoft.retirement.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RetirementAgeCalculatorService {

  public int calculateAge(int currentAge, int ageToRetire) {
    return currentAge - ageToRetire;
  }

}
