package com.luxoft.retirement.service;

import com.luxoft.retirement.converter.RetirementConverter;
import com.luxoft.retirement.model.Retirement;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetirementServiceTest {

  @Mock
  private RetirementConverter retirementConverter;

  @Mock
  private RetirementCalculationService retirementCalculationService;

  @Mock
  private RetirementMailService retirementMailService;

  @InjectMocks
  private RetirementService retirementService;

  @Test
  void calculateRetirement() {
    int ageToRetire = 65;
    int currentAge = 25;
    String email = "email@email.com";
    Retirement retirement = new Retirement();

    when(retirementCalculationService.calculateRetirement(eq(ageToRetire), eq(currentAge))).thenReturn(retirement);

    retirementService.calculateRetirement(ageToRetire, currentAge, email);

    verify(retirementCalculationService).calculateRetirement(eq(ageToRetire), eq(currentAge));
    verify(retirementMailService).sendMail(eq(retirement), eq(email));
    verify(retirementConverter).convert(eq(retirement));
  }

}