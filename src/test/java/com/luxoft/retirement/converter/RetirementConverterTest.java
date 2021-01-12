package com.luxoft.retirement.converter;

import com.luxoft.retirement.dto.RetirementResponse;
import com.luxoft.retirement.model.Retirement;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetirementConverterTest {

  @InjectMocks
  private RetirementConverter retirementConverter;

  @Test
  void Call_convert_method_should_return_converter_object() {
    Retirement retirement = new Retirement();
    retirement.setAgeLeft(40);
    retirement.setYearToRetire(2061);

    RetirementResponse result = retirementConverter.convert(retirement);

    assertAll("Should return converted object",
              () -> assertEquals(40, result.getAgeLeft()),
              () -> assertEquals(2061, result.getYearToRetire()));
  }

}