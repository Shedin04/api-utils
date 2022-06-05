package com.shedin.apicore.utility;

import com.shedin.apicore.constants.StringConstants;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;


@Log4j2
@NoArgsConstructor
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
		return getProperty(StringConstants.API_PROPERTIES_FILE, StringConstants.BASE_API_URL);
	}
}