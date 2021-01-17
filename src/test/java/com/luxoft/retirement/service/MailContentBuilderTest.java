package com.luxoft.retirement.service;

import com.luxoft.retirement.dto.MailContentDto;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MailContentBuilderTest {

  @Mock
  private ITemplateEngine templateEngine;

  @InjectMocks
  private MailContentBuilder mailContentBuilder;

  @Captor
  private ArgumentCaptor<Context> captor;

  @Test
  void build() {
    MailContentDto mailContentDto = MailContentDto.builder().build();

    when(templateEngine.process(any(String.class), any(Context.class))).thenReturn("html");

    String result = mailContentBuilder.build(mailContentDto);

    verify(templateEngine).process(anyString(), captor.capture());
    assertEquals(mailContentDto, captor.getValue().getVariable("mailContent"));
    assertEquals("html", result);
  }
}