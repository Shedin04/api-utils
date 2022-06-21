package com.shedin.apicore.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationAPIService {

	public String getProperty(String file, String key) {
		ClassLoader classLoader = ConfigurationAPIService.class.getClassLoader();
		Properties prop = new Properties();
		try {
			prop.load(classLoader.getResourceAsStream(file));
		}
		catch (IOException e) {
			log.warn(e.getMessage());
		}
		return prop.getProperty(key);
	}
}