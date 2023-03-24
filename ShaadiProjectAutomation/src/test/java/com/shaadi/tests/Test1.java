package com.shaadi.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shaadi.pages.LandingApp;



@Listeners(com.shaadi.base.TestListeners.class)
public class Test1 extends LandingApp{
	
	@BeforeClass
	public void setup() throws IOException{
		launch();
	}
	
	@Test
	public void test1() throws IOException, InterruptedException {
		clickLogin()
		.enterUserName("9970326575")
		.enterPassword("1234567")
		.login()//
		.clickMyShaadiLink()
		.clickConnectNow()//
		;
	}
	
	@AfterClass
	public void shutDown() {
		close();
	}

	@Override
	public void waitForPageToLoad() {
		
	}
	
}
