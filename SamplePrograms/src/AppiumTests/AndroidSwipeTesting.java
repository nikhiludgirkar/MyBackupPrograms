package AppiumTests;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidSwipeTesting {
	@Test
	public static void test1() throws IOException, InterruptedException {
		AndroidDriver driver;
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Huawei P20 Lite");
		dc.setCapability("udid", "86S7N18416001139");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");

		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		dc.setCapability("noReset", true);
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(url, dc);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Graphics']")).click();

		Dimension dimension=driver.manage().window().getSize();
		int startX=(int) (dimension.width*0.5);
		int startY=(int) (dimension.height*0.8);

		int endX=(int) (dimension.width*0.2);
		int endY=(int) (dimension.width*0.2);

		TouchAction touch=new TouchAction(driver);
		touch.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(endX, endY)).release().perform();
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().textContains(\"Sweep\"))"));
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Sweep']")).click();
		driver.quit();
	}
}
