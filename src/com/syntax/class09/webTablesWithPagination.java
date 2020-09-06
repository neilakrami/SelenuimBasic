package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTablesWithPagination {

	public static String url = "http://syntaxtechs.com/selenium-practice/table-pagination-demo.php";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'table table-hover']/tbody/tr"));
		boolean flag = true;
		
		while(flag) {
			for (WebElement row : rows) {
				String rowText = row.getText();
				if(rowText.contains("Arch J")) {
					flag = false;
					System.out.println(rowText);
					break;
				}
				
			}
			WebElement next = driver.findElement(By.linkText("Next"));
			next.click();
		}
	driver.quit();
	
	
	}

}
