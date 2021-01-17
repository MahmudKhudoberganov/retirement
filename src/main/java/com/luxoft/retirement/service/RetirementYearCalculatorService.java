package com.luxoft.retirement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RetirementYearCalculatorService {

  public int calculateYear(int ageLeft) {
    return LocalDate.now().getYear() + ageLeft;
  }

}
