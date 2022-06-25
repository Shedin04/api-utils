package com.shedin.apicore.helpers;

import com.shedin.apicore.utility.ConfigurationApiService;
import org.springframework.beans.factory.annotation.Autowired;

import static com.shedin.apicore.constants.StringConstants.BaseProperties.BASE_API_URL;
import static com.shedin.apicore.constants.StringConstants.FilePaths.API_PROPERTIES_FILE;


public class ConfigurationApiHelper {
	private static final String ENDPOINT_PROPERTY = ".endpoint";
	private final ConfigurationApiService configurationAPIService;
	private String baseURL;

	@Autowired
	public ConfigurationApiHelper(ConfigurationApiService configurationAPIService) {
		this.configurationAPIService = configurationAPIService;
	}

	public String getBaseURL() {
		if (baseURL == null) {
			baseURL = configurationAPIService.getProperty(API_PROPERTIES_FILE, BASE_API_URL);
		}
		return baseURL;
	}

	public String getEndpointUrl(String endpoint) {
		if (!endpoint.contains(ENDPOINT_PROPERTY)) {
			endpoint = endpoint + ENDPOINT_PROPERTY;
		}
		return configurationAPIService.getProperty(API_PROPERTIES_FILE, endpoint);
	}
}