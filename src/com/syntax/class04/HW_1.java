package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * HW 1
Go to http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html
Select any radiobutton and the age group ---> use List and loop 
Click on get values 
Verify the text in the page -- do not hardcode the values and compare
 */
public class HW_1 {

	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";
	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> sexRadioButton = driver.findElements(By.cssSelector("input[name = 'gender']"));
		
		String femaleGender = "Female";
		
		for (WebElement sexElement : sexRadioButton) {
			String gender = sexElement.getAttribute("value");
			if(gender.equals(femaleGender)) {
				sexElement.click();
				break;
			}
			
		}
		
		List<WebElement> ageRadioButton = driver.findElements(By.cssSelector("input[name = 'ageGroup']"));
		String age15_50 = "15 -50";
		for (WebElement ageElement : ageRadioButton) {
			
			String age = ageElement.getAttribute("value");
			if(age.equals(age15_50)) {
				ageElement.click();
				break;
				
			}
		}
		
		driver.findElement(By.className("button[onclick= 'getValues();']"));
		Thread.sleep(2000);
		

	}

}
