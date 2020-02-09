package com.itap.alm.service;

import com.itap.alm.beans.RestConnector;

public interface AlmAuthentication {
	
	public RestConnector login(final RestConnector connector) throws Exception;
	
	public String isAuthenticated(final RestConnector connector) throws Exception;
	
	public boolean logout(final RestConnector connector) throws Exception;
}
