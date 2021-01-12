package com.luxoft.retirement.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetirementYearCalculatorServiceTest {

  @InjectMocks
  private RetirementYearCalculatorService retirementYearCalculatorService;

  @Test
  void calculateYear() {
    int ageLeft = 40;

    int yearToRetire = retirementYearCalculatorService.calculateYear(ageLeft);

    int expectedYear = LocalDate.now().getYear() + ageLeft;
    assertEquals(expectedYear, yearToRetire);
  }

}