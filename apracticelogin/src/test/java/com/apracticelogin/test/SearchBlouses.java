package com.apracticelogin.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchBlouses {
private WebDriver driver; 
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void search_Blouses() {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search_query")));
		
		WebElement sb = driver.findElement( By.name("search_query")); 
		sb.clear();
		sb.sendKeys("blouse");
		
		
		
		WebElement submit_search = driver.findElement( By.name("submit_search")); 
		submit_search.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.heading-counter")));
		WebElement heading_counter = driver.findElement( By.cssSelector("span.heading-counter")); 
		
		System.out.println(heading_counter.getText());
		
		assertEquals(heading_counter.getText(), "1 result has been found.");
		
		//assertTrue(heading_counter.isDisplayed());
		
	}

	

	@After
	public void tearDown () {
		driver.quit();
	}
	
	
	
	
}
