package com.luxoft.retirement.service;

import com.luxoft.retirement.configuration.RetirementProperties;
import com.luxoft.retirement.converter.MailContentConverter;
import com.luxoft.retirement.converter.RetirementConverter;
import com.luxoft.retirement.dto.MailContentDto;
import com.luxoft.retirement.model.Retirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Slf4j
@Service
@AllArgsConstructor
public class RetirementMailService {

  private final RetirementProperties retirementProperties;

  private final MailContentConverter mailContentConverter;

  private final MailContentBuilder mailContentBuilder;

  private final MailService mailService;


  @Async
  public void sendMail(Retirement retirement, String email) {
    MailContentDto mailContent = mailContentConverter.convert(retirement);
    String template = mailContentBuilder.build(mailContent);
    mailService.sendMail(retirementProperties.getSubject(), email, template);
  }

}
