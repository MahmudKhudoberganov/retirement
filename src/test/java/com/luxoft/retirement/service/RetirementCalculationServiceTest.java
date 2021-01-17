package com.luxoft.retirement.service;

import com.luxoft.retirement.model.Retirement;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetirementCalculationServiceTest {

  @Mock
  private RetirementAgeCalculatorService retirementAgeCalculatorService;

  @Mock
  private RetirementYearCalculatorService retirementYearCalculatorService;

  @InjectMocks
  private RetirementCalculationService retirementCalculationService;


  @Test
  void Call_calculate_retirement_with_current_age_25_and_age_to_retire_65_should_return_calculation_of_retirement() {
    int currentAge = 25;
    int ageToRetire = 65;
    int expectedAgeLeft = 40;
    int expectedYearToRetire = 2061;

    when(retirementAgeCalculatorService.calculateAge(eq(currentAge), eq(ageToRetire))).thenReturn(expectedAgeLeft);
    when(retirementYearCalculatorService.calculateYear(eq(expectedAgeLeft))).thenReturn(expectedYearToRetire);

    Retirement retirement = retirementCalculationService.calculateRetirement(ageToRetire, currentAge);

    assertAll("Should return retirement calculation",
              () -> assertEquals(expectedAgeLeft, retirement.getAgeLeft()),
              () -> assertEquals(expectedYearToRetire, retirement.getYearToRetire()));
  }

}