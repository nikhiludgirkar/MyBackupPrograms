package AppiumTests;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidTestApp {
	@Test
	public static void test1() throws IOException, InterruptedException {
		WebDriver driver;
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Huawei P20 Lite");
		dc.setCapability("udid", "86S7N18416001139");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		
		dc.setCapability("appPackage", "com.isprid.birthdayreminder");
		dc.setCapability("appActivity", "com.isprid.birthdayreminder.activities.SplashActivity");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(5000);
		driver.findElement(By.id("android:id/button1")).click();
//		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.id("com.isprid.birthdayreminder:id/fab_main")).click();
		driver.findElement(By.id("com.isprid.birthdayreminder:id/edittext_dialog_name")).sendKeys("nikhiludg");
		
		driver.findElement(By.id("com.isprid.birthdayreminder:id/edittext_dialog_date")).click();
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(5000);
		boolean b=driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'nikhiludg')]")).isDisplayed();
		if (!b)
			System.out.println("failed");
		driver.quit();
		
	}
}
