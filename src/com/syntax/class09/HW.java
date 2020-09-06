package com.syntax.class09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW {

	public static String url = "https://www.aa.com/homePage.do";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Locating and typing the destination
		WebElement arrivingCity = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
		arrivingCity.sendKeys("SFO");
		//locating and assigning number 
		WebElement numOfPassDO = driver.findElement(By.id("flightSearchForm.adulthOrSeniorPassengerCount"));
		Select passDO = new Select(numOfPassDO);
		passDO.selectByVisibleText("2");
		//Locating and clicking on depart calendar
		WebElement departCalendar = driver.findElement(By.id("aa-leavingOn"));
		departCalendar.click();
		//locating  the months and getting the text of the element
		WebElement dMonth = driver.findElement(By.xpath("//span[@class = 'ul-datepicker-month']"));
		
		String departMonth = dMonth.getText();
		String expectedDMonth = "December";
		//loop to iterate over the month until it matches my expected month
		while(!departMonth.equals(expectedDMonth)) {
			
		WebElement next = driver.findElement(By.xpath("//a[@class = 'ul-datepicker-next ul-corner-all']"));
		next.click();
		WebElement next1 = driver.findElement(By.xpath("//a[@class = 'ul-datepicker-next ul-corner-all']"));
		next1.click();
		WebElement next2 = driver.findElement(By.xpath("//a[@class = 'ul-datepicker-next ul-corner-all']"));
		next2.click();
		WebElement next3 = driver.findElement(By.xpath("//a[@class = 'ul-datepicker-next ul-corner-all']"));
		next3.click();
		departMonth = expectedDMonth;
		}
		//creating a list to locate elements of the calendar table
		List<WebElement> departDates = driver.findElements(By.xpath("//table[@class = 'ul-datepicker-calendar']/tbody/tr/td"));
		//looping through the table until desired day is matched and clickin on it
		for (WebElement departDate : departDates) {
			if(departDate.getText().equals("4")) {
				departDate.click();
				break;
			}		
		}
		WebElement returnCalendar = driver.findElement(By.id("aa-returningFrom"));
		returnCalendar.clear();
		
		List<WebElement> returnDates = driver.findElements(By.xpath("//table[@class = 'ul-datepicker-calendar']/tbody/tr/td"));
		for (WebElement returnDate : returnDates) {
			if(returnDate.getText().endsWith("30")) {
				returnDate.click();
				break;
			}
			
		}
		//finally locating and clicking on the search button
		WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
		searchButton.click();

	}

}
