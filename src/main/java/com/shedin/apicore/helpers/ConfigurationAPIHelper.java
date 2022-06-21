package com.shedin.apicore.helpers;

import com.shedin.apicore.utility.ConfigurationAPIService;
import org.springframework.beans.factory.annotation.Autowired;

import static com.shedin.apicore.constants.StringConstants.BaseProperties.BASE_API_URL;
import static com.shedin.apicore.constants.StringConstants.FilePaths.API_PROPERTIES_FILE;


public class ConfigurationAPIHelper {
	@Autowired
	private ConfigurationAPIService configurationAPIService;
	private String baseURL;

	public String getBaseURL() {
		if (baseURL == null) {
			baseURL = configurationAPIService.getProperty(API_PROPERTIES_FILE, BASE_API_URL);
		}
		return baseURL;
	}

	public String getEndpointUrl(String endpoint) {
		return configurationAPIService.getProperty(API_PROPERTIES_FILE, endpoint);
	}
}