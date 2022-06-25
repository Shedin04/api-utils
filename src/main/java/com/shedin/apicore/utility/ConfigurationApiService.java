package com.shedin.apicore.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationApiService {

	public String getProperty(String file, String key) {
		ClassLoader classLoader = ConfigurationApiService.class.getClassLoader();
		Properties properties = new Properties();
		try {
			properties.load(classLoader.getResourceAsStream(file));
		}
		catch (IOException e) {
			log.warn(e.getMessage());
		}
		return properties.getProperty(key);
	}
}