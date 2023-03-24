package com.covid19.Covid19Project.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WDBase {
	private static WebDriver driver;

	public static void setDriver() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}


	public static WebDriver getDriver() {
		return driver;
	}

	public static void launch() throws IOException{
		setDriver();
		getDriver().get(EnvSpecificData.getData().get("url"));
	}

	public static void close() {
		if (getDriver()!=null) {
			getDriver().quit();
		}
	}
}
