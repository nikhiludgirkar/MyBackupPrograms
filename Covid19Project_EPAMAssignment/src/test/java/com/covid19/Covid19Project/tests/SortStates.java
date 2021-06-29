package com.covid19.Covid19Project.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SortStates{
	public static RequestSpecification getCommonSpec() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setAccept(ContentType.JSON);
		builder.setBaseUri("https://api.covid19india.org/");
		builder.setBasePath("data.json");
		RequestSpecification requestSpec=builder.build();
		return requestSpec;
	}
	public static void main(String[] args) {
		Response response=given()
				.spec(getCommonSpec())
			.get()
			.then()
			.statusCode(200)
			.extract()
			.response();
		JsonPath jsonPath=response.jsonPath();
		List<String> state=jsonPath.get("statewise.findAll{it.state!='Total' && it.state!='State Unassigned'}.state");
		List<String> deathCount=jsonPath.get("statewise.findAll{it.statecode!='TT' && it.statecode!='UN'}.deaths");
		Map<String, Integer> statewiseCount=new HashMap<String, Integer>();
		for (int x=0; x<deathCount.size(); x++) {
			statewiseCount.put(state.get(x), Integer.parseInt(deathCount.get(x)));
		}
//		System.out.println(statewiseCount);
		List<Integer> d=new ArrayList<Integer>();
		
		for (String a : deathCount) {
			d.add(Integer.parseInt(a));
		}
		
		Collections.sort(d, new SortCountInOrder());
		
		LinkedHashMap<String, Integer> sortedMap=new LinkedHashMap<String, Integer>();
		for (Integer a : d) {
			for (Map.Entry<String, Integer> m : statewiseCount.entrySet()) {
				if (m.getValue().equals(a)) {
					sortedMap.put(m.getKey(), m.getValue());
				}
			}
		}
		for (Map.Entry<String, Integer> m : sortedMap.entrySet())
			System.out.println(m.getKey()+"-> "+m.getValue());
	}
}
		