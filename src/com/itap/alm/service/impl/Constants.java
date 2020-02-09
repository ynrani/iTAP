package com.itap.alm.service.impl;

import java.util.Map;

public class Constants {

	/** The Constant TEST_INSTANCE. */
	public static final String TEST_INSTANCE = "test-instance";

	/** The Constant RUN. */
	public static final String RUN = "run";

	/** The Constant RUN-STEPS. */
	public static final String RUNSTEPS = "run-step";

	/** The Constant DEFECT. */
	public static final String DEFECT = "defect";

	/**
	 * This string used to create new "requirement" type entities.
	 */
	public static final String entityToPostName = "req" + Double.toHexString(Math.random());

	/** The Constant entityToPostFieldName. */
	public static final String entityToPostFieldName = "type-id";

	/** The Constant entityToPostFieldValue. */
	public static final String entityToPostFieldValue = "1";

	/** The Constant entityToPostFormat. */
	public static final String entityToPostFormat = "<Entities Type=\"requirement\">" + "<Fields>"
		+ Constants.generateFieldXml("%s", "%s") + Constants.generateFieldXml("%s", "%s") + "</Fields>" + "</Entities>";

	/** The Constant entityToPostXml. */
	public static final String entityToPostXml = String.format(entityToPostFormat, "name", entityToPostName, entityToPostFieldName,
		entityToPostFieldValue);

	/** The Constant entityToPostFieldXml. */
	public static final CharSequence entityToPostFieldXml = generateFieldXml(Constants.entityToPostFieldName,
		Constants.entityToPostFieldValue);

	/** The Constant postEntityFormat. */
	public static final String postEntityFormat = "<Entities Type=\"requirement\">" + "<Fields>"
		+ Constants.generateFieldXml("%s", "%s") + Constants.generateFieldXml("%s", "%s") + "</Fields>" + "</Entities>";

	/**
	 * Generate entity xml.
	 *
	 * @param entityName
	 *            the entity name
	 * @param fieldMap
	 *            the field map
	 * @return the string
	 */
	public static String generateEntityXml(final String entityName, final Map<String, String> fieldMap) {
		final StringBuilder sbEntity = new StringBuilder();
		sbEntity.append("<Entity Type=\"").append(entityName).append("\">");
		sbEntity.append("<Fields>");
		for (final Map.Entry<String, String> entry : fieldMap.entrySet()) {
			sbEntity.append(generateFieldXml(entry.getKey(), entry.getValue()));
		}
		sbEntity.append("</Fields>");
		sbEntity.append("</Entity>");
		return sbEntity.toString();
	}

	/**
	 * Generate field xml.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String generateFieldXml(final String field, final String value) {
		return "<Field Name=\"" + field + "\"><Value>" + value + "</Value></Field>";
	}

	/**
	 * Gets the entity id from url.
	 *
	 * @param entityUrl
	 *            the entity url
	 * @return the entity id from url
	 */
	public static String getEntityIdFromUrl(final String entityUrl) {
		return entityUrl.substring(entityUrl.lastIndexOf("/") + 1, entityUrl.length());
	}
}
