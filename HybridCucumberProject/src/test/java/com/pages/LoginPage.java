package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DBConnectivity;
import Utilities.User;

public class LoginPage {
	WebDriver driver;
	@FindBy(id = "txtUsername")
	WebElement username;
	@FindBy(id = "txtPassword")
	WebElement pwd;
	@FindBy(className = "button")
	WebElement Loginbutton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login(String uname, String pass)  {
		username.sendKeys(uname);
	    pwd.sendKeys(pass);
	   
	   
	}

	public void Submit() {
		Loginbutton.click();
	}
	public void Login() throws InterruptedException {
		DBConnectivity connector = new DBConnectivity();
        User user = connector.getCredentialsFromDB();
        username.sendKeys(user.getUserName());       
        pwd.sendKeys(user.getPassword());	  
        Loginbutton.click();
        
        
	}
}
