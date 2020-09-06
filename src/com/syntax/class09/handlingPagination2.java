package com.syntax.class09;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingPagination2 {

	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement pass = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		pass.sendKeys("Hum@nhrm123");
		loginButton.click();
		WebElement pim = driver.findElement(By.linkText("PIM"));
		pim.click();
		Thread.sleep(3000);
		WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
		addEmployee.click();
		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		firstName.sendKeys("aaaaa");
		lastName.sendKeys("bbbbbbbb");
		
		WebElement empIdELement = driver.findElement(By.id("employeeId"));
		String empId = empIdELement.getAttribute("value");
		
		WebElement saveButton = driver.findElement(By.id("btnSave"));
		saveButton.click();
		WebElement employeeList = driver.findElement(By.linkText("Employee List"));
		employeeList.click();
		
		WebElement sortByName = driver.findElement(By.xpath("//a[contains(text(), 'First ')]"));
		sortByName.click();
		
		boolean flag = true;
		while(flag) {
			List<WebElement> rows =driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
			for(int i =0; i<rows.size();i++) {//looping though table rows
				String rowText = rows.get(i).getText();
				if(rowText.contains(empId)) {
					flag = false;
					
					WebElement checkBox = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr[" +i+ "]/td[1]"));
	
							//getting i from iteration and location only the checkbod
					checkBox.click();
					WebElement delete = driver.findElement(By.id("btnDelete"));
					delete.click();
					WebElement confirmDelete = driver.findElement(By.id("dialogDeleteBtn"));
					confirmDelete.click();
					break;
					
				}
	
			}
			WebElement next = driver.findElement(By.linkText("Next"));
			next.click();
			
		}
		
	}

}
