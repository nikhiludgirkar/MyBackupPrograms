package org.coviddata.restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class CovidSiteResponse {
	
	@Test
	public void test1() {
		
		baseURI="https://api.covid19india.org";
		
		given()
			.get("/data.json")
		.then()
			.statusCode(200)
			.log()
			.all();
	}
	
}
