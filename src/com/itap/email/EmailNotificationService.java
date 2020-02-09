package com.itap.email;

import com.itap.exception.ServiceException;

public interface EmailNotificationService
{
	public void sendEmailNotification() throws ServiceException;
}
