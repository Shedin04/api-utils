package com.shedin.apicore.constants;

import lombok.experimental.UtilityClass;


@UtilityClass
public final class StringConstants {

	// file paths
	public enum FilePaths {;
		public static final String API_PROPERTIES_FILE = "api.properties";
	}

	// properties
	public enum BaseProperties {;
		public static final String BASE_API_URL = "base.api.url";
	}

	// request parameters
	public enum RequestParameters {;
		public static final String TOKEN = "token";
		public static final String COOKIE = "Cookie";
	}
}