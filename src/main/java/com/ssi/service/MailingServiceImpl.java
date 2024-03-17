package com.ssi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.ssi.models.Mail;

public class MailingServiceImpl implements MailingService {
	@Autowired
	private JavaMailSender javaMailSender;

	public void send(Mail mail) {
		SimpleMailMessage simpleMessage=new SimpleMailMessage();
		simpleMessage.setTo(mail.getMesssage());
		simpleMessage.setSubject(mail.getSubject());
		simpleMessage.setText(mail.getMesssage());
		
		javaMailSender.send(simpleMessage);
	}

}
