package com.syntax.class10;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://artoftesting.com/samplesiteforselenium");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// sample text
		
		WebElement sampleText = driver.findElement(By.xpath("//p[text() = 'This is sample text!']"));
		System.out.println(sampleText.getText());

		//This a link, separate window
		String mainPageHandle = driver.getWindowHandle();
		WebElement link = driver.findElement(By.xpath("//a[text() = 'This is a link']"));
		link.click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String windowHandle : allWindowHandles) {
			if(!windowHandle.equals("mainPageHandle")) {
				driver.switchTo().window(windowHandle);
//				driver.close();
			}
		}
		driver.switchTo().window(mainPageHandle);
		
		//TextBox
		
		
	}

}
