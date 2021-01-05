package com.luxoft.retirement.service;

import com.luxoft.retirement.dto.MailContentDto;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@AllArgsConstructor
public class MailService {

  private final JavaMailSender javaMailSender;

  @SneakyThrows
  public void sendMail(String subject, String to, String mailContent) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();

    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    helper.setSubject(subject);
    helper.setTo(to);
    helper.setText(mailContent, true);

    javaMailSender.send(mimeMessage);
  }

}
