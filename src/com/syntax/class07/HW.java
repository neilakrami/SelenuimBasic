package com.syntax.class07;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {

	public static String url = "https://demoqa.com/browser-windows";
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		String mainPageHandle = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement newTabBtn = driver.findElement(By.xpath("//button[@id='tabButton']"));
		newTabBtn.click();
		
		Set<String> allWindowhadles1 = driver.getWindowHandles();
		for (String currentWindow1 : allWindowhadles1) {
			driver.switchTo().window(currentWindow1);
		}
		System.out.println("Current page : "+driver.getCurrentUrl());
		
		WebElement text1= driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("Text from first window : "+ text1.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);
		System.out.println("Current page : "+driver.getCurrentUrl());
		
		WebElement newWindowBtn = driver.findElement(By.xpath("//button[text()='New Window']"));
		newWindowBtn.click();
		
		Set<String> allWindowHanles2 = driver.getWindowHandles();
		for (String currentWindow2 : allWindowHanles2) {
			driver.switchTo().window(currentWindow2);
		}
		System.out.println("Current page :"+ driver.getCurrentUrl());
		
		WebElement text2 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("Text from second window : "+ text2.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);
		
		WebElement logo = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jph']"));
		boolean isDisplayed = logo.isDisplayed();
		System.out.println("Is logo displayed? "+isDisplayed);
		System.out.println("Title of the page is : "+driver.getTitle());
		
	}

}
