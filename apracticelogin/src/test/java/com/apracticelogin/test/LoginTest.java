package com.apracticelogin.test;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginTest {
private WebDriver driver; 
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void logIn() {
		WebElement singIn = driver.findElement(By.className("login")); 
		singIn.click();
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("cris-f11@hotmail.com");
		
		WebElement password = driver.findElement(By.name("passwd"));
		password.sendKeys("Automatizacion");
		

		WebElement btn = driver.findElement(By.id("SubmitLogin"));
		btn.click();
		
		boolean blnError=false;
		try 
		{
			WebElement errorLoggin = driver.findElement(By.className("alert alert-danger"));
			errorLoggin.click();
			blnError=true;
		}
		catch(Exception e) {
			blnError=false;
		}
		
		
		
		if (blnError) {
			
			assertEquals("1", "0");
		}else {
			
			assertEquals("1", "1");
		}
		
	}

	

	@After
	public void tearDown () {
		driver.quit();
	}
	
	
	
	
}
