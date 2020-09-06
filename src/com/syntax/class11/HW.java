package com.syntax.class11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
/*
 * 1. delete the 5 row
 * 2.upload files
 * 3.fill all forms
 * 4.droppdown
 * 5.handel the popups
 * 6.drive and drop
 * 7.
 */

	
	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
	driver.get("http://www.uitestpractice.com/Students/Index");

	}

}
