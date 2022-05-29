package com.shedin.utility;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;

import static com.shedin.constants.StringConstants.API_PROPERTIES_FILE;
import static com.shedin.constants.StringConstants.BASE_API_URL;


@Log4j2
@UtilityClass
public class ConfigurationAPIHelper {

	public static String getProperty(String file, String key) {
		ClassLoader classLoader = ConfigurationAPIHelper.class.getClassLoader();
		Properties prop = new Properties();
		try {
			prop.load(classLoader.getResourceAsStream(file));
		}
		catch (IOException e) {
			log.warn(e.getMessage());
		}
		return prop.getProperty(key);
	}

	public static String getBaseURL() {
		return getProperty(API_PROPERTIES_FILE, BASE_API_URL);
	}
}