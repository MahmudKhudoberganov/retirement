package com.luxoft.retirement.converter;

import com.luxoft.retirement.dto.RetirementResponse;
import com.luxoft.retirement.model.Retirement;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RetirementConverter implements Converter<Retirement, RetirementResponse> {

  @Override
  public RetirementResponse convert(Retirement source) {
    return RetirementResponse.builder()
        .ageLeft(source.getAgeLeft())
        .yearToRetire(source.getYearToRetire())
        .build();
  }

}
