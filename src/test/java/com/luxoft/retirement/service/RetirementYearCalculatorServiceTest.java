package com.luxoft.retirement.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetirementYearCalculatorServiceTest {

  @InjectMocks
  private RetirementYearCalculatorService retirementYearCalculatorService;

  @Test
  public void Given_age_left_with_value_40_should_return_2061() {
    int ageLeft = 40;

    int result = retirementYearCalculatorService.calculateYear(ageLeft);

    assertEquals(2061, result);
  }

}