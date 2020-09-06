package com.syntax.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header
 */
public class HW_2_EbayCategories {

	public static String url="https://ebay.com";
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement allCaegories = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select select = new Select(allCaegories);
		List<WebElement> options = select.getOptions();
		
		Iterator<WebElement> it = options.iterator();
		while(it.hasNext()) {
			WebElement option = it.next();
			String optionText = option.getText();
			System.out.println(optionText);
		}
		
		select.selectByValue("58058");
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		Thread.sleep(2000);
		
		System.out.println("--------Verify the header----------------");
		
		String expectedText = "Computers, Tablets & Network Hardware";
		WebElement actualText = driver.findElement(By.xpath("//span[@class='b-pageheader__text']"));
		
		if(actualText.equals(expectedText)) {
			System.out.println("Task is done!");
			
		}else {
			System.out.println("Try again");
		}
		Thread.sleep(2000);
	}

}
