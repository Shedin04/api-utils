package com.shedin.apicore.utility;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonConverter {

	private JsonReader getReader(String file) {
		ClassLoader classLoader = JsonConverter.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(file);
		return new JsonReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
	}

	public Object convertJsonFileToObject(String file, Class<?> clz) {
		return new Gson().fromJson(getReader(file), clz);
	}
}