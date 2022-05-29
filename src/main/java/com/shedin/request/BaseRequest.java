package com.shedin.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import static com.shedin.constants.StringConstants.COOKIE;
import static io.restassured.RestAssured.given;


@UtilityClass
public class BaseRequest {

	public static Response getRequest(final String uri, final int statusCode, String token) {
		return given()
				.when()
				.header(COOKIE, token)
				.log().method()
				.log().uri()
				.log().headers()
				.get(uri)
				.then()
				.statusCode(statusCode)
				.extract().response();
	}


	public static Response postRequest(final String uri, final int statusCode, final Object raw, String token) {
		return given()
				.contentType(ContentType.JSON)
				.body(raw)
				.when()
				.header(COOKIE, token)
				.log().method()
				.log().body(true)
				.log().uri()
				.log().headers()
				.post(uri)
				.then()
				.statusCode(statusCode)
				.extract().response();
	}

	public static Response postRequest(final String uri, final int statusCode, final Object raw) {
		return given()
				.contentType(ContentType.JSON)
				.body(raw)
				.when()
				.log().method()
				.log().body(true)
				.log().uri()
				.post(uri)
				.then()
				.statusCode(statusCode)
				.extract().response();
	}
}