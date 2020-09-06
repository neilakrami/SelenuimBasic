package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_Task {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		driver.findElement(By.id("customer.firstName")).sendKeys("Ali");
		driver.findElement(By.id("customer.lastName")).sendKeys("Smith");
		driver.findElement(By.name("customer.address.street")).sendKeys("3800 Tassajara Road");
		driver.findElement(By.name("customer.address.city")).sendKeys("SF");
		driver.findElement(By.id("customer.address.state")).sendKeys("CA");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("87654");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("123456789");
		driver.findElement(By.name("customer.ssn")).sendKeys("123456789");
		driver.findElement(By.id("customer.username")).sendKeys("Ali");
		driver.findElement(By.name("customer.password")).sendKeys("Ali123");
		driver.findElement(By.id("repeatedPassword")).sendKeys("Ali123");
		driver.findElement(By.className("button")).click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
