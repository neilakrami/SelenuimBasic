package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Go to http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html
//click on each button and handle the alert accordingly
public class HW {

	public static String url = "http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement button1 = driver.findElement(By.cssSelector("button[class= 'btn btn-default']"));
		button1.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		WebElement button2 = driver.findElement(By.xpath("//button[@class = 'btn btn-default btn-lg']"));
		button2.click();
		Thread.sleep(2000);
		alert.dismiss();
		
		WebElement button3 = driver.findElement(By.xpath("//button[@class = 'btn btn-default btn-lg']"));
		button3.clear();
		alert.sendKeys("California");
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(4000);
		driver.quit();
		


	}

}
