package com.luxoft.retirement.converter;

import com.luxoft.retirement.dto.MailContentDto;
import com.luxoft.retirement.model.Retirement;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MailContentConverter implements Converter<Retirement, MailContentDto> {

  @Override
  public MailContentDto convert(Retirement source) {
    return MailContentDto.builder()
        .ageLeft(source.getAgeLeft())
        .currentYear(LocalDate.now().getYear())
        .yearToRetire(source.getYearToRetire())
        .build();
  }

}
