package com.shedin.apicore.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import java.util.Map;

import static io.restassured.RestAssured.given;


@UtilityClass
public class BaseRequest {

	public Response getRequest(final String uri, final Map<String, String> headers) {
		return given()
				.when()
				.headers(headers)
				.log().method()
				.log().uri()
				.log().headers()
				.get(uri)
				.then()
				.extract().response();
	}

	public Response getRequest(final String uri) {
		return given()
				.when()
				.log().method()
				.log().uri()
				.log().headers()
				.get(uri)
				.then()
				.extract().response();
	}

	public Response postRequest(final String uri, final Object raw, final Map<String, String> headers) {
		return given()
				.contentType(ContentType.JSON)
				.body(raw)
				.when()
				.headers(headers)
				.log().method()
				.log().body(true)
				.log().uri()
				.log().headers()
				.post(uri)
				.then()
				.extract().response();
	}

	public Response postRequest(final String uri, final Object raw) {
		return given()
				.contentType(ContentType.JSON)
				.body(raw)
				.when()
				.log().method()
				.log().body(true)
				.log().uri()
				.post(uri)
				.then()
				.extract().response();
	}
}