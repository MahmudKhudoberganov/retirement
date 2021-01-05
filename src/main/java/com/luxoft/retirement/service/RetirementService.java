package com.luxoft.retirement.service;

import com.luxoft.retirement.converter.RetirementConverter;
import com.luxoft.retirement.dto.MailContentDto;
import com.luxoft.retirement.dto.RetirementResponse;
import com.luxoft.retirement.model.Retirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Slf4j
@Service
@AllArgsConstructor
public class RetirementService {

  private final RetirementAgeCalculatorService retirementAgeCalculatorService;

  private final RetirementYearCalculatorService retirementYearCalculatorService;

  private final RetirementConverter retirementConverter;

  private final RetirementMailService retirementMailService;


  public RetirementResponse calculateRetirement(int ageToRetire, int currentAge, String email) {
    log.info("Calculating retirement. age to retire: {}, current age: {}", ageToRetire, currentAge);
    int ageLeft = retirementAgeCalculatorService.calculateAge(currentAge, ageToRetire);
    int yearToRetire = retirementYearCalculatorService.calculateYear(ageLeft);
    log.info("Retirement calculated. age left: {}, year to retire: {}", ageLeft, yearToRetire);

    Retirement retirement = new Retirement();
    retirement.setAgeLeft(ageLeft);
    retirement.setYearToRetire(yearToRetire);
    retirementMailService.sendMail(retirement, email);
    return retirementConverter.convert(retirement);
  }

}
