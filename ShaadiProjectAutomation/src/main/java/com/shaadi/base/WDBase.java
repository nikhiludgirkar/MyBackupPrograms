package com.shaadi.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WDBase {
	private static AndroidDriver<MobileElement> driver;
	private static Properties prop;
	public static void setDriver() throws MalformedURLException {
			
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Huawei P20 Lite");
		dc.setCapability("udid", "86S7N18416001139");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability(MobileCapabilityType.NO_RESET, false);
				
		dc.setCapability("appPackage", "com.shaadi.android");
		dc.setCapability("appActivity", "com.shaadi.android.ui.splash.SplashScreenActivity");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(url, dc);
	}


	public static AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	public static void launch() throws IOException{
		prop=PropertyReader.readProperties();
		setDriver();
	}

	public static void close() {
		if (driver!=null) {
			driver.quit();
		}
	}
}
