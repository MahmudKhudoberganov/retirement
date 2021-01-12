package com.luxoft.retirement.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MailServiceTest {

  @Mock
  private JavaMailSender javaMailSender;

  @InjectMocks
  private MailService mailService;

  @Captor
  private ArgumentCaptor<MimeMessage> captor;

  @Test
  void Call_send_mail_should_build_mime_message() {
    String subject = "subject";
    String to = "email@email.com";
    String mailContent = "hello";
    MimeMessage mimeMessage = Mockito.mock(MimeMessage.class);

    when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);

    mailService.sendMail(subject, to, mailContent);

    verify(javaMailSender).send(captor.capture());
    assertEquals(mimeMessage, captor.getValue());
  }

}