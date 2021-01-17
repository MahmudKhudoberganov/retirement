package com.luxoft.retirement.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetirementAgeCalculatorServiceTest {

  @InjectMocks
  private RetirementAgeCalculatorService retirementAgeCalculatorService;

  @Test
  void Call_calculate_age_method_with_current_age_25_and_age_to_retire_65_should_return_40() {
    int currentAge = 25;
    int ageToRetire = 65;

    int ageLeft = retirementAgeCalculatorService.calculateAge(currentAge, ageToRetire);

    assertEquals(40, ageLeft);
  }

}