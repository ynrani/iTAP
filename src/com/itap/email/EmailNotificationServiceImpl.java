package com.itap.email;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.itap.exception.ServiceException;

public class EmailNotificationServiceImpl implements EmailNotificationService
{
	private static final Logger LOGGER = Logger.getLogger(EmailNotificationServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	private VelocityEngine velocityEngine;

	@Override
	public void sendEmailNotification() throws ServiceException {
		// TODO Auto-generated method stub

	}

}