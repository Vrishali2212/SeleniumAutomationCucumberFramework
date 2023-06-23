package com.SeleniumAutomationCucumberFramework.stepDefination;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassStepDef {
	public   WebDriver driver =null ;

	public  void enterText(WebElement element, String value, String elementname) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(value) ; 
			System.out.println(elementname + " entered.");
			} 
			else {
				System.out.println("-- "+elementname + " is not displayed.");
			}
	}
	public  void enterText(WebElement element, String value) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(value) ; 
			System.out.println("Entered data in the webelement.");
			} 
			else {
				System.out.println("Element is not displayed.");
			}
	}
	
	public  void clickButton(WebElement element, String elementname) 
	{
		if (element.isDisplayed()) {
			element.click(); 
			System.out.println(elementname + " clicked ");
			}
			else {
				System.out.println("-- "+elementname+"  not displayed.");
			}
	}
	
	public  String getPageTitle() {
		//String pageTitle =  driver.getTitle() ; 
		//System.out.println("Page Title : " + pageTitle) ; 
		return driver.getTitle();
	}
	
	public  void clickCheckBox(WebElement checkboxElement) {
		if (checkboxElement.isDisplayed()) {
			if (checkboxElement.isSelected()) {
				System.out.println("Checkbox is already selected. ");
				
			}
			else {
				System.out.println("Clicking the checkbox");
				checkboxElement.click();
				System.out.println("Checked the checkbox") ; 
				
			}
		}else {
			System.out.println("Checkbox not displayed. ");
		}
		
	}
	
	public  void selectRadioButton(WebElement radiobutton ) {
		if (radiobutton.isSelected()) {
			System.out.println("Radio button is already selected") ; 
		} else {
			radiobutton.click(); 
			System.out.println("Radio button selected.")  ; 
		}
	}
	
	public  void waitTillElementVisible(By locator) {
		System.out.println("Waiting for page element to be visible. ");
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class) ;
		fwait.until(ExpectedConditions.visibilityOfElementLocated(locator)) ; 
				}
	public  void waitTillElementIsClickable(By by) {
		System.out.println("Waiting for page element to be clickable.. ");
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class) ;
		fwait.until(ExpectedConditions.elementToBeClickable(by)) ; 
				}
	

	
	
	public  void waitTillPageLoads(String pageTitle) {
		System.out.println("waitTillPageLoads::Waiting for page with title - "+pageTitle+" to be loaded. ");
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class) ;
		fwait.until(ExpectedConditions.titleContains(pageTitle)) ; 
	}
	
	
	
}



