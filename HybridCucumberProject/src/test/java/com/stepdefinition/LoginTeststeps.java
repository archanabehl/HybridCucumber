package com.stepdefinition;

import com.pages.LoginPage;

import BaseClass.Library;
import SeleniumUtility.SeleniumReusable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTeststeps extends Library {
	LoginPage lpage;
	@Given("To lunch the browser and navigate to URL")
	public void to_lunch_the_browser_and_navigate_to_URL() {
		browserSetUp();
		  logger.info("*******Browser Launch*********");
	   	}

	@When("To enter username and password")
	public void to_enter_username_and_password() {
		lpage=new LoginPage(driver);
		//	lpage.Login();
			lpage.Login("Admin", "admin123");
			logger.info("*******Enter username and password********");
	   
	}

	@Then("To click the submit button")
	public void to_click_the_submit_button() {
		lpage.Submit();
	    
	}

	@Then("To take the screenshot and close the browser")
	public void to_take_the_screenshot_and_close_the_browser() {
		SeleniumReusable util = new SeleniumReusable(driver);
		util.to_take_screenshot("./src/test/resources/Screenshotss/OrangehrmLogin.png");		
		logger.info("*******Screenshot Captured*********");
		tearDown();
	   
	}

}
