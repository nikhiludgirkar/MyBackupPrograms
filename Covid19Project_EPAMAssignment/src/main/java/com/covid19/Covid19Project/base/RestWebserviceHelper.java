package com.covid19.Covid19Project.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class RestWebserviceHelper {
	static RequestSpecification requestSpecification;
	
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

	public static Map<String, Integer> getStateCountByRest(String keyword, List<String> l) {
		Response response=given()
				.spec(getCommonSpec())
			.get()
			.then()
			.statusCode(200)
			.extract()
			.response();

		JsonPath jsonPath=response.jsonPath();
		HashMap<String, Integer> map=new HashMap<String, Integer>();

		for (int x=0; x<l.size(); x++) {
			String s=jsonPath.get("statewise.find{it.state.contains('"+l.get(x)+"')}."+keyword.toLowerCase());
			map.put(l.get(x), Integer.parseInt(s));
		}
		return map;
	}
	
	public static void getDistrictDetailsByState(String stateName, String cityName, String districtCount) {
		Response response=given()
				.spec(getCommonSpec2())
			.get()
			.then()
			.statusCode(200)
			.extract()
			.response();
		JsonPath jsonPath=response.jsonPath();
		int countFromRest=jsonPath.get(stateName+".districtData."+"'"+cityName+"'"+".active");
		districtCount=districtCount.replace(",", "");
		if (Integer.parseInt(districtCount)!=countFromRest)
			Assert.fail("City "+cityName+"count did not match "+districtCount);
	}
}
	