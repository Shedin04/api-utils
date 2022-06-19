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
	private static final ThreadLocal<HashMap<String, Object>> TEST_DATA = ThreadLocal.withInitial(HashMap::new);

	public static void saveSharedParameter(String key, Object value) {
		TEST_DATA.get().put(key, value);
	}

	public static Object getSharedParameter(String key) {
		return Optional.ofNullable(TEST_DATA.get().get(key))
				.orElseThrow(() -> {
					log.warn((format("There in no parameter with {%s} key", key)));
					return new IllegalArgumentException();
				});
	}

	public static String getToken() {
		return (String) getSharedParameter(TOKEN);
	}
}