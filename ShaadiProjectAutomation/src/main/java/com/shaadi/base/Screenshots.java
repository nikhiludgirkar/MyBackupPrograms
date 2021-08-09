package com.shaadi.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.shaadi.pages.LandingApp;

public class Screenshots extends LandingApp {
	public static void getScreenshot() throws IOException {
		File screencap=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		int timeMillis=(int)System.currentTimeMillis();
		String FileName="screenshot"+timeMillis+".jpg";
		FileHandler.copy(screencap, new File("././screenshots/"+FileName));
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		
	}
}
