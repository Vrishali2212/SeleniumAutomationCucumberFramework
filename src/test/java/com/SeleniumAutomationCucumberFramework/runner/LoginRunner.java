package com.SeleniumAutomationCucumberFramework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = {"src/test/resources/features/loginSalesForceFeature.feature"},
		glue = {"com.SeleniumAutomationCucumberFramework.stepDefination"},
		monochrome = true,
				dryRun= false
				
		)
public class LoginRunner extends AbstractTestNGCucumberTests {

}
