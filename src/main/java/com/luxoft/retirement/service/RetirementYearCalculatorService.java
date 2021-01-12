package com.luxoft.retirement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@AllArgsConstructor
public class RetirementYearCalculatorService {

  public int calculateYear(int ageLeft) {
    return Calendar.getInstance().get(Calendar.YEAR) + ageLeft;
  }

}
