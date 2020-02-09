package com.itap.alm.beans;

import java.util.Map;

public class Response {

	/** The response headers. */
	private Map<String, ? extends Iterable<String>> responseHeaders = null;

	/** The response data. */
	private byte[] responseData = null;

	/** The failure. */
	private Exception failure = null;

	/** The status code. */
	private int statusCode = 0;

	/**
	 * Instantiates a new response.
	 *
	 * @param responseHeaders
	 *            the response headers
	 * @param responseData
	 *            the response data
	 * @param failure
	 *            the failure
	 * @param statusCode
	 *            the status code
	 */
	public Response(final Map<String, Iterable<String>> responseHeaders, final byte[] responseData, final Exception failure,
		final int statusCode) {
		super();
		this.responseHeaders = responseHeaders;
		this.responseData = responseData;
		this.failure = failure;
		this.statusCode = statusCode;
	}

	/**
	 * Instantiates a new response.
	 */
	public Response() {}

	/**
	 * Gets the response headers.
	 *
	 * @return the responseHeaders
	 */
	public Map<String, ? extends Iterable<String>> getResponseHeaders() {
		return responseHeaders;
	}

	/**
	 * Sets the response headers.
	 *
	 * @param responseHeaders
	 *            the responseHeaders to set
	 */
	public void setResponseHeaders(final Map<String, ? extends Iterable<String>> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	/**
	 * Gets the response data.
	 *
	 * @return the responseData
	 */
	public byte[] getResponseData() {
		return responseData;
	}

	/**
	 * Sets the response data.
	 *
	 * @param responseData
	 *            the responseData to set
	 */
	public void setResponseData(final byte[] responseData) {
		this.responseData = responseData;
	}

	/**
	 * Gets the failure.
	 *
	 * @return the failure if the access to the requested URL failed, such as a
	 *         404 or 500. If no such failure occured this method returns null.
	 */
	public Exception getFailure() {
		return failure;
	}

	/**
	 * Sets the failure.
	 *
	 * @param failure
	 *            the failure to set
	 */
	public void setFailure(final Exception failure) {
		this.failure = failure;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(final int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see Object#toString() return the contents of the byte[] data as a
	 *      string.
	 */
	@Override
	public String toString() {

		return new String(this.responseData);
	}

}
