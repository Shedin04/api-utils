package com.shedin;

import static io.restassured.RestAssured.given;


public class APIUtils {

	public static String sendGetRequest(final String url) {
		return given()
				.when()
				.get(url)
				.then()
				.extract().response().asPrettyString();
	}
}