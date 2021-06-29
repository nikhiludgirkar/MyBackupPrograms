package com.covid19.Covid19Project.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.covid19.Covid19Project.base.LandingApp;
import com.covid19.Covid19Project.base.RestWebserviceHelper;


public class Test1 extends LandingApp{
	@BeforeClass
	public void setup() throws IOException {
		launch();
	}

	@Test
	public void test1() throws InterruptedException {
		List<String> topDeceasedStateNames=getTopStatesNamesFromUI("Deceased", 3);
		Map<String, Integer> deceasedMap=RestWebserviceHelper.getStateCountByRest("deaths", topDeceasedStateNames);
		compareResultsWithWeb("deceased", deceasedMap);

		List<String> topConfirmedStateNames=getTopStatesNamesFromUI("Confirmed", 3);
		Map<String, Integer> confirmedMap=RestWebserviceHelper.getStateCountByRest("Confirmed", topConfirmedStateNames);
		compareResultsWithWeb("confirmed", confirmedMap);

		List<String> stateNames=getTopStatesNamesFromUI("Active", 3);
		System.out.println(stateNames);

		for (int x=0; x<stateNames.size(); x++) {
			Map<String, String> districtCount=clickListAndReturnDistrictwiseCount(stateNames.get(x));
//			System.out.println(districtCount);
			for (Map.Entry<String, String> m : districtCount.entrySet()) {
				RestWebserviceHelper.getDistrictDetailsByState(stateNames.get(x), m.getKey(), m.getValue());
			}
		}
	}

	@AfterClass
	public void shutDown() {
		close();
	}
}
