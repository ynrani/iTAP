package com.itap.alm.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.itap.alm.beans.Response;
import com.itap.alm.beans.RestConnector;
import com.itap.alm.service.AlmIntegrationService;

@Component("AlmIntegrationService")
public class AlmIntegrationServiceImpl implements AlmIntegrationService {

	public int createNewDefect(RestConnector restConnector,
			final HashMap<String, String> fieldMap, String screenshotPath) {
		try {
			restConnector = new AlmAuthenticationImpl().login(restConnector);
			final String postedEntityXml = Constants.generateEntityXml(
					Constants.DEFECT, fieldMap);
			final String collectionUrl = restConnector
					.buildEntityCollectionUrl(Constants.DEFECT);
			final String defectUrl = createEntity(restConnector, collectionUrl,
					postedEntityXml);
			final String defectIdString = defectUrl.split("defects/")[1];

			if (!defectIdString.equals("0")) {
				createAttachmentEntity(restConnector, defectIdString,
						screenshotPath);
			}
			return Integer.parseInt(defectIdString);
		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String createEntity(final RestConnector connector,
			final String collectionUrl, final String postedEntityXml)
			throws Exception {
		final Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/xml");
		requestHeaders.put("Accept", "application/xml");
		final Response response = connector.httpPost(collectionUrl,
				postedEntityXml.getBytes(), requestHeaders);
		final Exception failure = response.getFailure();
		if (failure != null) {
			throw failure;
		}
		final String entityUrl = response.getResponseHeaders().get("Location")
				.iterator().next();
		return entityUrl;
	}

	private void createAttachmentEntity(final RestConnector connector,
			final String defectId, final String screenshotPath)
			throws Exception {
		File screenshotFile = new File(screenshotPath);
		if (screenshotFile != null && screenshotFile.exists()) {
			final byte[] array = Files.readAllBytes(new File(screenshotPath)
					.toPath());
			final Map<String, String> requestHeaders = new HashMap<String, String>();
			requestHeaders.put("Content-Type", "application/octet-stream");
			requestHeaders.put("Accept", "application/json");
			requestHeaders.put("Content-Disposition", "attachment");
			requestHeaders.put("filename", "Attachment.JPG");
			final String collectionUrl = connector
					.buildDefectAttachmentCollectionUrl(defectId);
			final Response response = connector.httpPostSpecific(collectionUrl,
					array, requestHeaders);
			final Exception failure = response.getFailure();
			if (failure != null) {
				throw failure;
			}
		}
	}
}
