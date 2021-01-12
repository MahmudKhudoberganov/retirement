package com.luxoft.retirement.service;

import com.luxoft.retirement.configuration.RetirementProperties;
import com.luxoft.retirement.converter.MailContentConverter;
import com.luxoft.retirement.dto.MailContentDto;
import com.luxoft.retirement.model.Retirement;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetirementMailServiceTest {

  @Mock
  private RetirementProperties retirementProperties;

  @Mock
  private MailContentConverter mailContentConverter;

  @Mock
  private MailContentBuilder mailContentBuilder;

  @Mock
  private MailService mailService;

  @InjectMocks
  private RetirementMailService retirementMailService;


  @Test
  void Call_send_mail_with_retirement_should_invoke_all_services() {
    Retirement retirement = new Retirement();
    String email = "Email@email";
    MailContentDto mailContentDto = MailContentDto.builder().build();

    when(mailContentConverter.convert(eq(retirement))).thenReturn(mailContentDto);

    retirementMailService.sendMail(retirement, email);

    verify(retirementProperties).getSubject();
    verify(mailContentBuilder).build(eq(mailContentDto));
    verify(mailContentConverter).convert(eq(retirement));
  }

}