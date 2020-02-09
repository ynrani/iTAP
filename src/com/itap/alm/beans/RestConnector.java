package com.itap.alm.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RestConnector {

	private Map<String, String> cookies;
	private String serverUrl;
	private String domain;

	/** The project. */
	private String project;

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/**
	 * Inits the.
	 *
	 * @param userName
	 *            the user name
	 * @param password
	 *            the password
	 * @param cookies
	 *            the cookies
	 * @param serverUrl
	 *            the server url
	 * @param domain
	 *            the domain
	 * @param project
	 *            the project
	 */
	public void init(final String userName, final String password, final Map<String, String> cookies, final String serverUrl,
		final String domain, final String project) {

		this.cookies = cookies;
		this.serverUrl = serverUrl;
		this.domain = domain;
		this.project = project;
		this.userName = userName;
		this.password = password;

	}

	/**
	 * Gets the cookies.
	 *
	 * @return the cookies
	 */
	public Map<String, String> getCookies() {
		return cookies;
	}

	/**
	 * Sets the cookies.
	 *
	 * @param cookies
	 *            the cookies to set
	 */
	public void setCookies(final Map<String, String> cookies) {
		this.cookies = cookies;
	}

	/**
	 * Gets the server url.
	 *
	 * @return the serverUrl
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * Sets the server url.
	 *
	 * @param serverUrl
	 *            the serverUrl to set
	 */
	public void setServerUrl(final String serverUrl) {
		this.serverUrl = serverUrl;
	}

	/**
	 * Gets the domain.
	 *
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Sets the domain.
	 *
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(final String domain) {
		this.domain = domain;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project
	 *            the project to set
	 */
	public void setProject(final String project) {
		this.project = project;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Builds the entity collection url.
	 *
	 * @param entityType
	 *            the entity type
	 * @return the string
	 */
	public String buildEntityCollectionUrl(final String entityType) {
		return buildUrl("rest/domains/" + domain + "/projects/" + project + "/" + entityType + "s");
	}

	/**
	 * Builds the entity url.
	 *
	 * @param entityType
	 *            the entity type
	 * @param entityId
	 *            the entity id
	 * @return the string
	 */
	public String buildEntityUrl(final String entityType, final String entityId) {
		return buildUrl("rest/domains/" + domain + "/projects/" + project + "/" + entityType + "s/" + entityId);
	}

	/**
	 * Builds the entity url.
	 *
	 * @param entityType
	 *            the entity type
	 * @param entityId
	 *            the entity id
	 * @return the string
	 */
	public String buildEntityUrlForRun(final String runId) {
		return buildUrl("rest/domains/" + domain + "/projects/" + project + "/runs/" + runId);
	}

	/**
	 * Builds the url.
	 *
	 * @param path
	 *            the path
	 * @return the string
	 */
	public String buildUrl(final String path) {
		return String.format("%1$s/%2$s", serverUrl, path);
	}

	/**
	 * Http put.
	 *
	 * @param url
	 *            the url
	 * @param data
	 *            the data
	 * @param headers
	 *            the headers
	 * @return the response
	 * @throws Exception
	 *             the exception
	 */
	public Response httpPut(final String url, final byte[] data, final Map<String, String> headers) throws Exception {
		return doHttp("PUT", url, null, data, headers, cookies);
	}

	/**
	 * Http post.
	 *
	 * @param url
	 *            the url
	 * @param data
	 *            the data
	 * @param headers
	 *            the headers
	 * @return the response
	 * @throws Exception
	 *             the exception
	 */
	public Response httpPost(final String url, final byte[] data, final Map<String, String> headers) throws Exception {
		return doHttp("POST", url, null, data, headers, cookies);
	}

	/**
	 * Http delete.
	 *
	 * @param url
	 *            the url
	 * @param headers
	 *            the headers
	 * @return the response
	 * @throws Exception
	 *             the exception
	 */
	public Response httpDelete(final String url, final Map<String, String> headers) throws Exception {
		return doHttp("DELETE", url, null, null, headers, cookies);
	}

	/**
	 * Http get.
	 *
	 * @param url
	 *            the url
	 * @param queryString
	 *            the query string
	 * @param headers
	 *            the headers
	 * @return the response
	 * @throws Exception
	 *             the exception
	 */
	public Response httpGet(final String url, final String queryString, final Map<String, String> headers) throws Exception {
		return doHttp("GET", url, queryString, null, headers, cookies);
	}

	/**
	 * Do http.
	 *
	 * @param type
	 *            http operation: get post put delete
	 * @param url
	 *            to work on
	 * @param queryString
	 *            the query string
	 * @param data
	 *            to write, if a writable operation
	 * @param headers
	 *            to use in the request
	 * @param cookies
	 *            to use in the request and update from the response
	 * @return http response
	 * @throws Exception
	 *             the exception
	 */
	private Response doHttp(final String type, final String url, final String queryString, final byte[] data,
		final Map<String, String> headers, final Map<String, String> cookies) throws Exception {

		final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

		con.setRequestMethod(type);
		final String cookieString = getCookieString();

		prepareHttpRequest(con, headers, data, cookieString);
		con.connect();
		final Response ret = retrieveHtmlResponse(con);

		updateCookies(ret);

		return ret;
	}

	public void GetQCSession(final RestConnector restConnector) {
		final String qcsessionurl = restConnector.buildUrl("rest/site-session");
		final Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/xml");
		requestHeaders.put("Accept", "application/xml");
		try {
			final Response resp = restConnector.httpPost(qcsessionurl, null, requestHeaders);
			restConnector.updateCookies(resp);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prepare http request.
	 *
	 * @param con
	 *            connection to set the headers and bytes in
	 * @param headers
	 *            to use in the request, such as content-type
	 * @param bytes
	 *            the actual data to post in the connection.
	 * @param cookieString
	 *            the cookies data from clientside, such as lwsso, qcsession,
	 *            jsession etc.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void prepareHttpRequest(final HttpURLConnection con, final Map<String, String> headers, final byte[] bytes,
		final String cookieString) throws IOException {

		String contentType = null;

		// attach cookie information if such exists
		if (cookieString != null && !cookieString.isEmpty()) {

			con.setRequestProperty("Cookie", cookieString);
		}

		// send data from headers
		if (headers != null) {

			// Skip the content-type header - should only be sent
			// if you actually have any content to send. see below.
			contentType = headers.remove("Content-Type");

			final Iterator<Entry<String, String>> headersIterator = headers.entrySet().iterator();
			while (headersIterator.hasNext()) {
				final Entry<String, String> header = headersIterator.next();
				con.setRequestProperty(header.getKey(), header.getValue());
			}
		}

		// If there's data to attach to the request, it's handled here.
		// Note that if data exists, we take into account previously removed
		// content-type.
		if (bytes != null && bytes.length > 0) {

			con.setDoOutput(true);

			// warning: if you add content-type header then you MUST send
			// information or receive error.
			// so only do so if you're writing information...
			if (contentType != null) {
				con.setRequestProperty("Content-Type", contentType);
			}

			final OutputStream out = con.getOutputStream();
			out.write(bytes);
			out.flush();
			out.close();
		}
	}

	/**
	 * Retrieve html response.
	 *
	 * @param con
	 *            that is already connected to its url with an http request, and
	 *            that should contain a response for us to retrieve
	 * @return a response from the server to the previously submitted http
	 *         request
	 * @throws Exception
	 *             the exception
	 */
	private Response retrieveHtmlResponse(final HttpURLConnection con) throws Exception {

		final Response ret = new Response();

		ret.setStatusCode(con.getResponseCode());
		ret.setResponseHeaders(con.getHeaderFields());

		InputStream inputStream;
		// select the source of the input bytes, first try 'regular' input
		try {
			inputStream = con.getInputStream();
		}

		/*
		 * If the connection to the server somehow failed, for example 404 or
		 * 500, con.getInputStream() will throw an exception, which we'll keep.
		 * We'll also store the body of the exception page, in the response
		 * data.
		 */
		catch (final Exception e) {

			inputStream = con.getErrorStream();
			ret.setFailure(e);
		}

		// This actually takes the data from the previously set stream
		// (error or input) and stores it in a byte[] inside the response
		final ByteArrayOutputStream container = new ByteArrayOutputStream();

		final byte[] buf = new byte[1024];
		int read;
		while ((read = inputStream.read(buf, 0, 1024)) > 0) {
			container.write(buf, 0, read);
		}

		ret.setResponseData(container.toByteArray());

		return ret;
	}

	/**
	 * Update cookies.
	 *
	 * @param response
	 *            the response
	 */
	private void updateCookies(final Response response) {

		final Iterable<String> newCookies = response.getResponseHeaders().get("Set-Cookie");
		if (newCookies != null) {

			for (final String cookie : newCookies) {
				final int equalIndex = cookie.indexOf('=');
				final int semicolonIndex = cookie.indexOf(';');

				final String cookieKey = cookie.substring(0, equalIndex);
				final String cookieValue = cookie.substring(equalIndex + 1, semicolonIndex);

				cookies.put(cookieKey, cookieValue);
			}
		}
	}

	/**
	 * Gets the cookie string.
	 *
	 * @return the cookie string
	 */
	public String getCookieString() {
		final StringBuilder sb = new StringBuilder();

		if (!cookies.isEmpty()) {

			final Set<Entry<String, String>> cookieEntries = cookies.entrySet();
			for (final Entry<String, String> entry : cookieEntries) {
				sb.append(entry.getKey()).append("=").append(entry.getValue()).append(";");
			}
		}

		final String ret = sb.toString();

		return ret;
	}

	@Override
	public String toString() {
		return "RestConnector [cookies=" + cookies + ", serverUrl=" + serverUrl + ", domain=" + domain + ", project=" + project
			+ ", userName=" + userName + ", password=" + password + "]";
	}
	
	/**
	 * Builds the entity collection url.
	 *
	 * @param entityType
	 *            the entity type
	 * @return the string
	 */
	public String buildDefectAttachmentCollectionUrl(final String defectId) {
		return buildUrl("rest/domains/" + domain + "/projects/" + project + "/defects/" + defectId + "/attachments");
	}
	
	public Response httpPostSpecific(final String url, final byte[] data, final Map<String, String> headers) throws Exception {
		return httpPostSpecific("POST", url, null, data, headers, cookies);
	}
	
	private Response httpPostSpecific(final String type, final String url, final String queryString, final byte[] data,
			final Map<String, String> headers, final Map<String, String> cookies) throws Exception {

			final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			final String cookieString = getCookieString();

			con.setRequestMethod(type);
			con.setRequestProperty("Cookie", cookieString);
			con.addRequestProperty("Content-Type", "application/octet-stream");
			con.addRequestProperty("Slug", "Screenshot.JPG");
			con.setDoOutput(true);
			
			final OutputStream out = con.getOutputStream();
			out.write(data);
			con.connect();
			
			final Response ret = retrieveHtmlResponse(con);
			updateCookies(ret);

			return ret;
		}
}
