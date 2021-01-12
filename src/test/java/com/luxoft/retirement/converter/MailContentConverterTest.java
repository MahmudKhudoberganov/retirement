package com.luxoft.retirement.converter;

import com.luxoft.retirement.dto.MailContentDto;
import com.luxoft.retirement.dto.RetirementResponse;
import com.luxoft.retirement.model.Retirement;
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
class MailContentConverterTest {

  @InjectMocks
  private MailContentConverter mailContentConverter;


  @Test
  void Call_convert_method_should_return_converter_object() {
    Retirement retirement = new Retirement();
    retirement.setAgeLeft(40);
    retirement.setYearToRetire(2061);

    MailContentDto result = mailContentConverter.convert(retirement);

    assertAll("Should return converted object",
              () -> assertEquals(40, result.getAgeLeft()),
              () -> assertEquals(LocalDate.now().getYear(), result.getCurrentYear()),
              () -> assertEquals(2061, result.getYearToRetire()));
  }
}