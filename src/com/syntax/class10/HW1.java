package com.syntax.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

	public static String url = "https://www.delta.com/";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement calendar  = driver.findElement(By.id("input_dpartureDate_1"));
		calendar.click();
		
		WebElement dMonth = driver.findElement(By.className("dl-datepicker-month-0"));
		String departMonth = dMonth.getText();
		WebElement next = driver.findElement(By.xpath("//span[text() = 'Next']"));
		do {
			next.click();
			departMonth = dMonth.getText();
		}while(!departMonth.equals("October"));
		
	
	}

}
