package com.covid19.Covid19Project.tests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.RestAssured.*;

public class HamcrestMatchers {
	public static RequestSpecification getCommonSpec() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setAccept(ContentType.JSON);
		builder.setBaseUri("https://api.covid19india.org/");
		builder.setBasePath("data.json");
		RequestSpecification requestSpec=builder.build();
		return requestSpec;
	}

	public static RequestSpecification getCommonSpec2() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setAccept(ContentType.JSON);
		builder.setBaseUri("https://api.covid19india.org/");
		builder.setBasePath("state_district_wise.json");
		RequestSpecification requestSpec=builder.build();
		return requestSpec;
	}

	@Test(enabled=false)
	public void m1(){
		given()
		.spec(getCommonSpec())
		.when()
		.get()
		.then()
		.assertThat()
		//				.body("statewise.find{it.statecode=='AR'}.deaths", hasItem("199"))
		.body("statewise.find{it.state=='Maharashtra'}.deaths",hasItem("121945"));

	}

	@Test
	public void m2(){
		Response res=
				given()
				.spec(getCommonSpec2())
				.when()
				.get()
				.then()
				.extract().response();
		
		Response res2 = RestAssured.given()
	            .get("https://api.covid19india.org/state_district_wise.json");
		Map<String, ?> data = res2.jsonPath().getMap("Maharashtra.districtData");
		
		
		Set<String> keys = data.keySet();
		int sum=0;
		for (String key : keys) {
		    int deceased = JsonPath.read(res.asString(), String.format("$.Maharashtra.districtData.[\"%s\"].deceased", key));
		    sum += deceased;
		}
//		int sum = keys.stream().mapToInt(key ->
//				JsonPath.read(res.asString(), String.format("$.Maharashtra.districtData.[\"%s\"].deceased", key))).sum();
		System.out.println(sum);

		//		String str=jsonPath.get("statewise.collect{it.deaths}.sum()");
		//		System.out.println(str);

	}
}