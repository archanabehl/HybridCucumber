package com.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "./src/test/resources/Features/Testcase.feature",
					plugin = {"pretty", "html:reports/cucumberreport","json:reports/cucumberreport/jsonreport",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
			glue="com.stepdefinition",
			strict= true
						
			)

	public class TestRunner{
		
			
		  @AfterClass
		  
		  public static void Extentsreport()
		  
		  {
			  Reporter.loadXMLConfig("./src/test/resources/Extent.config.xml");
		  Reporter.setSystemInfo("user", System.getProperty("user.name"));
		  Reporter.setSystemInfo("os", "Windows");
		  Reporter.setTestRunnerOutput("Sample test runner output message"); }
		 

	}

