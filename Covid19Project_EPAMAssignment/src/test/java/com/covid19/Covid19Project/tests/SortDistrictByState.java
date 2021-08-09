

package com.covid19.Covid19Project.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SortDistrictByState implements Comparable<Object>{
	public static RequestSpecification getCommonSpec() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setAccept(ContentType.JSON);
		builder.setBaseUri("https://api.covid19india.org/");
		builder.setBasePath("state_district_wise.json");
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

		Map<String, ?> map=jsonPath.get("Maharashtra.districtData");

		String a="";
		System.out.println("full data is "+map);
		Map<String, String> districtDeathData=new LinkedHashMap<String, String>();
		for (Map.Entry<String, ?> m : map.entrySet()) {
			System.out.println("key "+m.getKey());

		String a=null;
		System.out.println("full data is "+map);
		Map<String, String> districtDeathData=new LinkedHashMap<String, String>();
		for (Map.Entry<String, ?> m : map.entrySet()) {
			a=m.getValue().toString();
			int index=a.indexOf("deceased");
			int fullIndex=index+9;
			districtDeathData.put(m.getKey(), a.substring(fullIndex).split(",")[0]);
//			System.out.println("fullIndex"+fullIndex);
//			String[] p=a.split(",");
//			int pos=p[0].length();
//			System.out.println("position is "+pos);
//			a=a.substring(fullIndex, pos);
//			a=a.replaceAll(",", "");
//			districtData.put(m.getKey(), a);
		}
//		a=a.substring(169, 173);
		List<Integer> deceasedCountList=new ArrayList<Integer>();
		Map<String, Integer> newConvertedMap=new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, String> m : districtDeathData.entrySet()) {
			deceasedCountList.add(Integer.parseInt(m.getValue()));
			newConvertedMap.put(m.getKey(), Integer.parseInt(m.getValue()));
		}
		Collections.sort(deceasedCountList, Collections.reverseOrder());
		Map<String, Integer> sortedMap=new LinkedHashMap<String, Integer>();
		for (Integer i : deceasedCountList) {
			for (Map.Entry<String, Integer> m : newConvertedMap.entrySet()) {
				if (m.getValue().equals(i)) {
					sortedMap.put(m.getKey(), m.getValue());
				}
			}
		}
		
		System.out.println("sorted according to deaths");
		
		for (Map.Entry<String, Integer> m : sortedMap.entrySet()) {
			System.out.println(m.getKey()+"-> "+m.getValue());
		}
		
//			System.out.println(m.getKey()+"-> "+m.getValue());
		}
		Map<String, String> map2=new LinkedHashMap<String, String>();
		for (Map.Entry<String, ?> m : map.entrySet()) {
			a=m.getValue().toString();
			int index=a.indexOf("active=");
			int fullIndex=index+7;
			map2.put(m.getKey(), a.substring(fullIndex).split(",")[0]);
		}
		System.out.println("sorted according to active cases");
//		System.out.println(map2);
		
		System.out.println(map2);
	}

	@Override
	public int compareTo(Object o) {
		int a=Integer.parseInt(this.toString());
		int b=Integer.parseInt(o.toString());
		return a-b;
		
	}

}
}
