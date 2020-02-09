package com.itap.alm.service.impl;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.itap.alm.beans.Base64Encoder;
import com.itap.alm.beans.Response;
import com.itap.alm.beans.RestConnector;
import com.itap.alm.service.AlmAuthentication;

@Component("almAuthentication")
public class AlmAuthenticationImpl implements AlmAuthentication{

	public RestConnector login(final RestConnector connector) throws Exception {
		final String authenticationPoint = isAuthenticated(connector);
		if (authenticationPoint != null) {
			return login(authenticationPoint, connector);
		}
		return connector;
	}

	private RestConnector login(final String loginUrl, final RestConnector connector) throws Exception {
		final byte[] credBytes = (connector.getUserName() + ":" + connector.getPassword()).getBytes();
		final String credEncodedString = "Basic " + Base64Encoder.encode(credBytes);

		final Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", credEncodedString);
		final Response response = connector.httpGet(loginUrl, null, map);
		final boolean ret = response.getStatusCode() == HttpURLConnection.HTTP_OK;
		if (ret) {
			final String qcsessionurl = connector.buildUrl("rest/site-session");
			final Map<String, String> requestHeaders = new HashMap<String, String>();
			requestHeaders.put("Content-Type", "application/xml");
			requestHeaders.put("Accept", "application/xml");
			try {
				connector.httpPost(qcsessionurl, null, requestHeaders);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		return connector;
	}

	public String isAuthenticated(final RestConnector connector) throws Exception {
		final String isAuthenticateUrl = connector.buildUrl("rest/is-authenticated");
		String ret;

		final Response response = connector.httpGet(isAuthenticateUrl, null, null);
		final int responseCode = response.getStatusCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			final String qcsessionurl = connector.buildUrl("rest/site-session");
			final Map<String, String> requestHeaders = new HashMap<String, String>();
			requestHeaders.put("Content-Type", "application/xml");
			requestHeaders.put("Accept", "application/xml");
			try {
				connector.httpPost(qcsessionurl, null, requestHeaders);
			} catch (final Exception e) {
				e.printStackTrace();
			}
			ret = null;
		}

		else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
			final Iterable<String> authenticationHeader = response.getResponseHeaders().get("WWW-Authenticate");
			String newUrl = authenticationHeader.iterator().next().split("=")[1];
			newUrl = newUrl.replace("\"", "");
			newUrl += "/authenticate";
			ret = newUrl;
		} else {
			throw response.getFailure();
		}
		return ret;
	}

	public boolean logout(final RestConnector connector) throws Exception {
		final Response response = connector.httpGet(connector.buildUrl("authentication-point/logout"), null, null);
		return response.getStatusCode() == HttpURLConnection.HTTP_OK;
	}

}
