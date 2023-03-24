package com.covid19.Covid19Project.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LandingApp extends WDBase{

	public static void startTest() {
		try {
			launch();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static List<WebElement> getStatesFromUI() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0, 500)");
		List<WebElement> states=getDriver().findElements(By.xpath("//div[@class='cell'][1]/child::div[contains(@class, 'state-name')]"));
		return states;
	}

	public static void navigateToHome() throws InterruptedException {
		getDriver().findElement(By.xpath("//div[@class='navbar-middle']/child::a[contains(.,'Covid19')]")).click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0, 500)");
	}
	
	public static List<String> getTopStatesNamesFromUI(String keyword, int topNumber) throws InterruptedException{
		Thread.sleep(5000);
		if (!keyword.equalsIgnoreCase("active")) {
			getDriver().findElement(By.xpath("//div[contains(@class, 'cell heading')]/child::div[contains(.,'"+keyword+"')]")).click();
		}
		List<WebElement> states=getStatesFromUI();
		ArrayList<String> topStateNames=new ArrayList<String>();
		for (int x=0; x<topNumber; x++) {
			if (x<3) {
				topStateNames.add(states.get(x).getText());
			}
		}
		return topStateNames;
	}

	public void compareResultsWithWeb(String keyword, Map<String, Integer> results) {

		for (Map.Entry<String, Integer> m : results.entrySet()) {
			String stateName=m.getKey();
			String stateCountFromUI=getDriver().findElement(By.xpath("//div[contains(@class, 'state-name')][contains(.,'"+stateName+"')]/parent::div/following-sibling::div[@class='cell statistic']/child::div[@class='delta is-"+keyword+"']/following-sibling::div[@class='total']")).getText();
			stateCountFromUI=stateCountFromUI.replace(",", "");
			int parsedAmount=Integer.parseInt(stateCountFromUI);
			if (m.getValue()!=parsedAmount)
				Assert.fail(keyword+" count did not match");
		}
	}
	
	public Map<String, String>clickListAndReturnDistrictwiseCount(String stateName) throws InterruptedException {
		navigateToHome();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//div[contains(@class, 'row heading')]/following-sibling::div/child::div/child::div[contains(.,'"+stateName+"')]")).click();
		getDriver().findElement(By.xpath("//span[contains(.,'See more')]")).click();
		WebDriverWait wait=new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElements(By.xpath("//div[@class='district']/h2"))));
		List<WebElement> topDistrictsCount=getDriver().findElements(By.xpath("//div[@class='district']/h2"));
		wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElements(By.xpath("//div[@class='district']/h5"))));
		List<WebElement> topDistricts=getDriver().findElements(By.xpath("//div[@class='district']/h5"));
		Map<String, String> districtCountMap=new HashMap<String, String>();
		for (int x=0; x<topDistricts.size(); x++) {
				districtCountMap.put(topDistricts.get(x).getText(), topDistrictsCount.get(x).getText());
		}
		return districtCountMap;
	}
}