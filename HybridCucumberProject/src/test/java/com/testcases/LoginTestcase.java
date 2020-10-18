package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;

import BaseClass.Library;
import SeleniumUtility.SeleniumReusable;

public class LoginTestcase extends Library {
	@BeforeTest
	public void startUp() {
  browserSetUp();
  logger.info("*******Browser Launch*********");
		//launchApplication("chrome","https://opensource-demo.orangehrmlive.com/");
		
		
	}
	@Test
	public void login() throws InterruptedException {
		LoginPage lpage=new LoginPage(driver);
	//	lpage.Login();
		lpage.Login("Admin", "admin123");
		logger.info("*******Enter username and password********");
		
	}
	@AfterTest
	public void close() throws IOException {
		SeleniumReusable util = new SeleniumReusable(driver);
		util.to_take_screenshot("src/test/resources/Screenshots");		
		logger.info("*******Screenshot Captured*********");
		tearDown();
		
	}

}
