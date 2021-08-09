package com.shaadi.pages;

import org.openqa.selenium.By;

import com.shaadi.base.WDBase;


public abstract class LandingApp extends WDBase {
	
	public LoginPage clickLogin() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//*[@resource-id='com.shaadi.android:id/btn_morph_login']")).click();

		return new LoginPage();
	}
	
	
	public abstract void waitForPageToLoad();
}
