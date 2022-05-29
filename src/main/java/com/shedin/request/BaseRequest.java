package com.shedin.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.shedin.constants.StringConstants.COOKIE;
import static io.restassured.RestAssured.given;


public class BaseRequest {

	private BaseRequest() {}

	public static Response getRequest(final String uri, final int statusCode, String token) {
		return given()
				.when()
				.log().method()
				.log().uri()
				.header(COOKIE, token)
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
				.log().method()
				.log().body(true)
				.log().uri()
				.header(COOKIE, token)
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