package com.shaadi.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LandingApp {
	
	
	public LoginPage enterUserName(final String userName) {
		waitForPageToLoad();
		getDriver().findElement(By.xpath("//*[@resource-id='com.shaadi.android:id/edt_username']")).sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(final String password) {
		getDriver().findElement(By.xpath("//*[@resource-id='com.shaadi.android:id/edt_password']")).sendKeys(password);
		return this;
	}
	
	public HomePage login() {
		getDriver().findElement(By.xpath("//*[@resource-id='com.shaadi.android:id/btn_login']")).click();
		return new HomePage();
	}

	@Override
	public void waitForPageToLoad() {
		WebDriverWait wait=new WebDriverWait(getDriver(), 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.shaadi.android:id/btn_login']")));
	}
}
