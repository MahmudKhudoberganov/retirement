package com.luxoft.retirement.service;

import com.luxoft.retirement.converter.RetirementConverter;
import com.luxoft.retirement.dto.RetirementResponse;
import com.luxoft.retirement.model.Retirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RetirementService {

  private final RetirementConverter retirementConverter;

  private final RetirementCalculationService retirementCalculationService;

  private final RetirementMailService retirementMailService;


  public RetirementResponse calculateRetirement(int ageToRetire, int currentAge, String email) {
    Retirement retirement = retirementCalculationService.calculateRetirement(ageToRetire, currentAge);
    retirementMailService.sendMail(retirement, email);
    return retirementConverter.convert(retirement);
  }

}
