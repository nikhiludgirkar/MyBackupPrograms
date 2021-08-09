package com.covid19.Covid19Project.tests;


import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.covid19.Covid19Project.base.LandingApp;
import com.covid19.Covid19Project.base.RestWebserviceHelper;


public class Test1 extends LandingApp{
	@Test
	public void test1() throws InterruptedException {
		startTest();
		
		/*
		 * Validating at least 2 of the details like Confirmed, Deceased with the data from API for the three states.
		 * SCENARIO 1
		 */
		
		List<String> topDeceasedStateNames=getTopStatesNamesFromUI("Deceased", 3);
		Map<String, Integer> deceasedMap=RestWebserviceHelper.getStateCountByRest("deaths", topDeceasedStateNames);
		compareResultsWithWeb("deceased", deceasedMap);

		List<String> topConfirmedStateNames=getTopStatesNamesFromUI("Confirmed", 3);
		Map<String, Integer> confirmedMap=RestWebserviceHelper.getStateCountByRest("Confirmed", topConfirmedStateNames);
		compareResultsWithWeb("confirmed", confirmedMap);
		
		List<String> stateNames=getTopStatesNamesFromUI("Active", 3);
		System.out.println("The TOP 3 states are : "+stateNames);

		/*
		 * Validating the district totals
		 * SCENARIO 2
		 */
		
		for (int x=0; x<stateNames.size(); x++) {
			Map<String, String> districtCount=clickListAndReturnDistrictwiseCount(stateNames.get(x));
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
