package com.shedin.apicore.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Optional;

import static com.shedin.apicore.constants.StringConstants.TOKEN;
import static java.lang.String.format;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestContext {
	private static HashMap<String, Object> TEST_DATA;

	public static void saveSharedParameter(String key, Object value) {
		if (TEST_DATA == null) {
			TEST_DATA = new HashMap<>();
		}
		TEST_DATA.put(key, value);
	}

	public static Object getSharedParameter(String key) {
		return Optional.ofNullable(TEST_DATA.get(key))
				.orElseThrow(() -> {
					log.warn((format("There in no parameter with {%s} key", key)));
					return new IllegalArgumentException();
				});
	}

	public static String getToken() {
		return (String) getSharedParameter(TOKEN);
	}
}