package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElement {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://Facebook.com");
		driver.findElement(By.id("email")).sendKeys("syntax");
		driver.findElement(By.id("pass")).sendKeys("syntax123");
		driver.findElement(By.id("u_0_b")).click();
		driver.findElement(By.linkText("Forgot Password?")).click();

		driver.findElement(By.partialLinkText("Forgot")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
