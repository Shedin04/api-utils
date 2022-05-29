package com.shedin.utility;




import com.google.gson.stream.JsonReader;
import lombok.extern.log4j.Log4j2;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;


@Log4j2
public class JsonConverter {

	public static JsonReader getReader(String file) {
		ClassLoader classLoader = JsonConverter.class.getClassLoader();
		InputStream in = classLoader.getResourceAsStream(file);
		return new JsonReader(new InputStreamReader(Objects.requireNonNull(in)));
	}
}