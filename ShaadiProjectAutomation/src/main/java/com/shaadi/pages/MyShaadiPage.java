package com.shaadi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.shaadi.exceptions.ExplicitAssertionError;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class MyShaadiPage extends LandingApp{


	public MyShaadiPage clickConnectNow() throws InterruptedException {
		Thread.sleep(5000);

		Dimension dim=getDriver().manage().window().getSize();

		int starty=(int) (dim.height*0.80);
		int endy=(int) (dim.height*0.20);
		int startx=dim.width/2;
		int endx = (int) (dim.width * 0.30);

		TouchAction touchAction = new TouchAction(getDriver());

		touchAction.longPress(PointOption.point(startx, starty))
		.moveTo(PointOption.point(endx, endy))
		.release()
		.perform();
		Thread.sleep(5000);
		List<MobileElement> premiumMatches=getDriver().findElements(By.xpath("//android.widget.TextView[@text='Connect Now']"));
		if (premiumMatches.size()!=0)
			getDriver().findElement(By.xpath("//android.widget.TextView[@text='Connect Now']")).click();
		else
			throw new ExplicitAssertionError("Connect Now button is not present");
		
		List<MobileElement> photoPopup=getDriver().findElements(By.xpath("//*[@resource-id='com.shaadi.android:id/btnDismiss']"));
		if (photoPopup.size()!=0)
			getDriver().findElement(By.xpath("//*[contains(@resource-id,'com.shaadi.android:id/btnDismiss')]")).click();

		touchAction.longPress(PointOption.point(startx, starty))
		.moveTo(PointOption.point(endx, endy))
		.release()
		.perform();
		List<MobileElement> newMatches=getDriver().findElements(By.xpath("//android.widget.TextView[@text='Connect Now']"));
		if (newMatches.size()!=0)
			getDriver().findElement(By.xpath("//android.widget.TextView[@text='Connect Now']")).click();
		else
			throw new ExplicitAssertionError("Connect Now button is not present");


		
		return this;
	}

	@Override
	public void waitForPageToLoad() {
	}

}
