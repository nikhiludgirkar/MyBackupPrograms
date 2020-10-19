package AppiumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidCalculatorTest {
	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver;
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Huawei P20 Lite");
		dc.setCapability("udid", "86S7N18416001139");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		
		dc.setCapability("appPackage", "com.android.calculator2");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(url, dc);
	}
}
