package com.shedin.apicore.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import static com.shedin.apicore.constants.StringConstants.RequestParameters.COOKIE;
import static io.restassured.RestAssured.given;


@UtilityClass
public class BaseRequest {

	public Response getRequest(final String uri, final int statusCode, String token) {
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


	public Response postRequest(final String uri, final int statusCode, final Object raw, String token) {
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

	public Response postRequest(final String uri, final int statusCode, final Object raw) {
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