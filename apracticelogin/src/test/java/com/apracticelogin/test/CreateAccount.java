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

public class CreateAccount {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	/**
	 * 
	 */
	@Test
	public void Create() {
		WebElement singIn = driver.findElement(By.className("login"));
		singIn.click();

		WebElement email = driver.findElement(By.name("email_create"));
		email.sendKeys("test11@test11.com");

		WebElement btn = driver.findElement(By.id("SubmitCreate"));
		btn.click();
		boolean blnError = false;
		try {
			WebElement errorLoggin = driver.findElement(By.className("alert alert-danger"));
			blnError = true;
		} catch (Exception e) {
			blnError = false;
		}

		if (blnError) {
			assertEquals("1", "0");
			return;
		} else {
			assertEquals("1", "1");
		}

		if (!blnError) {
			WebDriverWait wait = new WebDriverWait(driver, 7);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));
			WebElement customer_firstname = driver.findElement(By.name("customer_firstname"));
			customer_firstname.sendKeys("First name");

			WebElement customer_lastname = driver.findElement(By.name("customer_lastname"));
			customer_lastname.sendKeys("Last name");

			WebElement passwd = driver.findElement(By.name("passwd"));
			passwd.sendKeys("password1234");

			WebElement days = driver.findElement(By.name("days"));
			days.sendKeys("12");

			WebElement months = driver.findElement(By.name("months"));
			months.sendKeys("January");

			WebElement years = driver.findElement(By.name("years"));
			years.sendKeys("1970");

			WebElement company = driver.findElement(By.name("company"));
			company.sendKeys("My compañía");

			WebElement address1 = driver.findElement(By.name("address1"));
			address1.sendKeys("Calle 100");

			WebElement city = driver.findElement(By.name("city"));
			city.sendKeys("Medellin");

			WebElement id_state = driver.findElement(By.name("id_state"));
			id_state.sendKeys("New York");

			WebElement postcode = driver.findElement(By.name("postcode"));
			postcode.sendKeys("98876");

			WebElement id_country = driver.findElement(By.name("id_country"));
			id_country.sendKeys("United States");

			WebElement phone_mobile = driver.findElement(By.name("phone_mobile"));
			phone_mobile.sendKeys("+573000000000");

			WebElement alias = driver.findElement(By.name("alias"));
			alias.clear();
			alias.sendKeys("myAlias");
			
			WebElement submitAccount = driver.findElement(By.name("submitAccount"));
			submitAccount.click();
			
			try {
				WebElement errorLoggin2 = driver.findElement(By.className("alert alert-danger"));
				blnError = true;
			} catch (Exception e) {
				blnError = false;
			}
			
			if (blnError) {
				assertEquals("1", "0");
				return;
			} else {
				assertEquals("1", "1");
			}
		}

	}

	@After
	public void tearDown() {
		// driver.quit();
	}

}
