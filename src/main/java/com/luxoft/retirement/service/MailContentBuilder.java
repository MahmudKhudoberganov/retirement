package com.luxoft.retirement.service;

import com.luxoft.retirement.dto.MailContentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailContentBuilder {

  private final TemplateEngine templateEngine;

  public String build(MailContentDto contentDto) {
    Context context = new Context();
    context.setVariable("mailContent", contentDto);
    return templateEngine.process("retirement_email", context);
  }

}
