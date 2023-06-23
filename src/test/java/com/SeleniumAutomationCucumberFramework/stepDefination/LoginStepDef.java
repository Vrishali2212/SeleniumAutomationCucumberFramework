package com.SeleniumAutomationCucumberFramework.stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.SeleniumAutomationCucumberFramework.utility.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef extends BaseClassStepDef{
	
	
	@Before
	public void beforeMethod() {
		System.out.println("Inside beforeMethod()");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@After
	public void afterMethod() {
		System.out.println("Inside afterMethod()");
		driver.close();
	}
	
	
	@Given("Login page is open")
	public void login_page_is_open() {
		
		PropertiesUtility property_utility = new PropertiesUtility();
		String url = property_utility.getPropertyValue("url");
		driver.get(url) ;   // to load website
		System.out.println("URL: "+url +" launched.") ; 
		String actualTitle=driver.getTitle();
		System.out.println("Actual title = "+actualTitle);
		String expectedTitle="Login | Salesforce";
		Assert.assertEquals(actualTitle, expectedTitle);
	
	}

	@When("i enter username and password")
	public void i_enter_username_and_password() {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		String myusername = propertiesUtility.getPropertyValue("login.valid.userid");
	//System.out.println("Userid from property file fetched = " + myusername); 
	
	String mypassword = propertiesUtility.getPropertyValue("login.valid.password") ; 
	 
	WebElement usernameE = driver.findElement( By.id("username")) ; 
	enterText(usernameE,myusername , "UserName") ; 
	WebElement passwordE = driver.findElement(By.id("password")) ; 
	enterText(passwordE,mypassword, "Passoword" ) ;
	
	}

	@When("login button is clicked")
	public void login_button_is_clicked() {
		WebElement loginbtnE = driver.findElement(By.id("Login")) ; 
		clickButton(loginbtnE,"Login Button") ; 
	}

	@Then("Home Page should be displayed")
	public void home_page_should_be_displayed() {
		waitTillElementVisible(By.id("phSearchInput"));
		String actualTitle1=getPageTitle();
		String expectedTitle1="Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualTitle1, expectedTitle1);
		//exreport.logExtentPass("Login Successful.Logged in to Sales Force Home Page.");
		System.out.println("-----------------------------------------------------------------------------") ;
	}
	
	@When("i enter username and blank password")
	public void i_enter_username_and_blank_password() {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		String myusername = propertiesUtility.getPropertyValue("login.valid.userid"); 
		System.out.println("Userid from property file fetched = " + myusername) ; 
		String mypassword = ""; 
		System.out.println("Password from property file fetched = " + mypassword); 
		WebElement usernameE = driver.findElement( By.id("username")) ; 
		enterText(usernameE,myusername , "UserName") ; 
		WebElement passwordE = driver.findElement(By.id("password")) ; 
		enterText(passwordE,mypassword, "Passoword" ) ;
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		String expectedError = "Please enter your password." ;
		By actualErrMsg = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]");
		WebElement actualErrMsgE = driver.findElement(actualErrMsg) ;
		Assert.assertEquals(actualErrMsgE.getText(), expectedError) ; 
	}
	
	@When("i check remember me checkbox")
	public void i_check_remember_me_checkbox() {
		WebElement rememberMe = driver.findElement(By.xpath("//label[text()='Remember me']"));
		clickCheckBox(rememberMe) ; 
	}

	@When("click on usermenu dropdown")
	public void click_on_usermenu_dropdown() {
		WebElement profileE = driver.findElement(By.id("userNavLabel")) ;
		profileE.click();
	}

	@When("click on logout button")
	public void click_on_logout_button() {
		WebElement logoutE = driver.findElement(By.xpath("//a[text()='Logout']"));
		logoutE.click();
	}

	@Then("Login Salesforce page is displayed")
	public void login_salesforce_page_is_displayed() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals("Login | Salesforce", getPageTitle()) ; 
	}

	@Then("Remember Me checkbox is checked")
	public void remember_me_checkbox_is_checked() {
		WebElement rememberMe2 = driver.findElement(By.xpath("//input[@name='rememberUn']"));
		if (rememberMe2.isDisplayed()) {
			if (rememberMe2.isSelected()) {
				System.out.println("Checkbox is already selected. ");
				//System.out.println("PASS >> Test case  passed");
				 
				
			}else {
				System.out.println("-- Checkbox is NOT selected. ");
				 
			}
			
		}else {
			System.out.println("Checkbox not displayed. ");	
		}
	}

	@Then("Valid username present in the username field")
	public void valid_username_present_in_the_username_field() {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		String myusername = propertiesUtility.getPropertyValue("login.valid.userid");
		WebElement username =  driver.findElement( By.id("username")) ; 
		String actualUsernameValue = username.getAttribute("value") ;
		String expectedUsernameValue = myusername ; 
		Assert.assertEquals(actualUsernameValue, expectedUsernameValue) ; 
	}
	
	@When("i click Forgot Your Password link")
	public void i_click_forgot_your_password_link() {
		WebElement forgotPasswordE = driver.findElement(By.linkText("Forgot Your Password?")) ; 
		forgotPasswordE.click();
	}

	@Then("Forgot Password page is displayed")
	public void forgot_password_page_is_displayed() throws InterruptedException {
		Thread.sleep(5000);
		String expectedTitle ="Forgot Your Password | Salesforce" ;
		Assert.assertEquals(expectedTitle, getPageTitle());
	}

	@When("i Provide username in salesforce forgot password page and click on contiue button")
	public void i_provide_username_in_salesforce_forgot_password_page_and_click_on_contiue_button() {
		WebElement usernameTextBoxE = driver.findElement(By.xpath("//input[@id='un']"));
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		String myusername = propertiesUtility.getPropertyValue("login.valid.userid");
		enterText(usernameTextBoxE, myusername, "UserName") ; 
		WebElement continuebtnE = driver.findElement(By.id("continue")) ; 
		clickButton(continuebtnE,"Continue") ; 
	}

	@Then("Password reset message page is displayed")
	public void password_reset_message_page_is_displayed() throws InterruptedException {
		Thread.sleep(2000);
		String expectedTitle2 = "Check Your Email | Salesforce" ; 
		Assert.assertEquals(getPageTitle(), expectedTitle2) ;
		WebElement headerE = driver.findElement(By.id("header"));
		Assert.assertEquals(headerE.getText(), "Check Your Email") ;
		
	}

	@When("i enter wrong username and wrong password")
	public void i_enter_wrong_username_and_wrong_password() {
		String invalidusername ="123" ;
		String invalidpassword="221331";
		
		WebElement usernameE = driver.findElement( By.id("username")) ; 
		enterText(usernameE,invalidusername , "UserName") ; 
		WebElement passwordE = driver.findElement(By.id("password")) ; 
		enterText(passwordE,invalidpassword, "Passoword" ) ;
	}
	
	@Then("Error message should be displayed Your login attempt has failed")
	public void error_message_should_be_displayed_login_attempt_failed() {
		String actualErrorText =  driver.findElement(By.id("error")).getText();
		String expectedErrorText = "Please check your username and password. If you still can't log in, contact your Salesforce administrator." ;
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}


}
