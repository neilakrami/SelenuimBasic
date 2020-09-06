package com.syntax.class05;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Go to facebook sign up page
Fill out the whole form
Click signup
 */
public class HW_1_FacebookSignUp {

	public static String url = "https://www.facebook.com/r.php?locale=en_US&display=page";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		WebElement firstName = driver.findElement(By.xpath("//input[@name = 'firstname']"));
		firstName.sendKeys("Neil");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name = 'lastname']"));
		lastName.sendKeys("Smith");
		
		WebElement email = driver.findElement(By.xpath("//input[@name = 'reg_email__']"));
		email.sendKeys("NeilSmith@gmail.com");
		
		WebElement ReEnterEmail = driver.findElement(By.xpath("//input[@name = 'reg_email_confirmation__']"));
		Thread.sleep(2000);
		if(ReEnterEmail.isDisplayed()) {
			ReEnterEmail.sendKeys("NeilSmith@gmail.com");
		}
		
		
		WebElement password = driver.findElement(By.xpath("//input[@name = 'reg_passwd__']"));
		password.sendKeys("abc123@123");
				
		WebElement month = driver.findElement(By.id("month"));
		Select selectMonoth = new Select(month);
		selectMonoth.selectByValue("5");
		
		WebElement day = driver.findElement(By.id("day"));
		Select selectDay = new Select(day);
		selectDay.selectByIndex(03);
		
		WebElement yearDD = driver.findElement(By.id("year"));
		Select selectYear = new Select(yearDD);
		selectYear.selectByVisibleText("1999");
		
		List<WebElement> radioBtn = driver.findElements(By.name("sex"));
		for (WebElement webElement : radioBtn) {
			String value = webElement.getAttribute("value");
			if(value.equals("1")) {
				webElement.click();
				break;
			}	
		}
		
		WebElement signUp = driver.findElement(By.xpath("//button[@name= 'websubmit']"));
		signUp.click();
		Thread.sleep(2000);

	}

}
