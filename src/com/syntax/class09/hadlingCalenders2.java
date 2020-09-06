package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hadlingCalenders2 {

	public static String url ="https://www.delta.com";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
		calendar.click();
		WebElement dMonth = driver.findElement(By.id("dl-datepicker-month-0"));//locating departure month
		String dpartMonth = dMonth.getText();
		WebElement next = driver.findElement(By.xpath("//span[text() = 'Next']"));
		while(!dpartMonth.equals("November")) {
			next.click();
			dpartMonth = dMonth.getText();
		}

		List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
		for (WebElement departDate : departDates) {
			if(departDate.getText().equals("20")) {
				departDate.click();
				break;
			}
			
		}
		WebElement rMonth = driver.findElement(By.className("dl-datepicker-month-1"));
		String returnMonth = rMonth.getText();
		while(!returnMonth.equals("December")) {
			next.click();
			returnMonth = rMonth.getText();
		}
		
		List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
		for (WebElement returnDate : returnDates) {
			if(returnDate.getText().equals("20")) {
				returnDate.click();
				break;
			}
			
		}
		WebElement done = driver.findElement(By.className("donebutton"));
		done.click();
	}

}
