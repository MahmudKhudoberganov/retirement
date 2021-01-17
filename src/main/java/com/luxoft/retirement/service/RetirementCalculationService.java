package com.luxoft.retirement.service;

import com.luxoft.retirement.model.Retirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RetirementCalculationService {

  private final RetirementAgeCalculatorService retirementAgeCalculatorService;

  private final RetirementYearCalculatorService retirementYearCalculatorService;


  public Retirement calculateRetirement(int ageToRetire, int currentAge) {
    log.info("Calculating retirement. age to retire: {}, current age: {}", ageToRetire, currentAge);
    int ageLeft = retirementAgeCalculatorService.calculateAge(currentAge, ageToRetire);
    int yearToRetire = retirementYearCalculatorService.calculateYear(ageLeft);
    log.info("Retirement calculated. age left: {}, year to retire: {}", ageLeft, yearToRetire);

    Retirement retirement = new Retirement();
    retirement.setAgeLeft(ageLeft);
    retirement.setYearToRetire(yearToRetire);
    return retirement;
  }

}
