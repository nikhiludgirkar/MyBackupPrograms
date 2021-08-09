package com.shaadi.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class HomePage extends LandingApp{

	
	
	public MyShaadiPage clickMyShaadiLink() throws InterruptedException {
		waitForPageToLoad();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//*[@resource-id='com.shaadi.android:id/imgMyShaadi']")).click();
		return new MyShaadiPage();
	}
	
	
	
	@Override
	public void waitForPageToLoad() {
//		getDriver().findElement(By.);
		WebDriverWait wait=new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.shaadi.android:id/imgMyShaadi']")));
		List<MobileElement> vipShaadiPopup=getDriver().findElements(By.xpath("//*[@resource-id='com.shaadi.android:id/img_cancel']"));
		if (vipShaadiPopup.size()!=0)
			getDriver().findElement(By.xpath("//*[@resource-id='com.shaadi.android:id/img_cancel']")).click();
	}

}
