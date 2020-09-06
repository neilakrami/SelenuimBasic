package com.syntax.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.syntax.Utils.BaseClass;
import com.syntax.class10.TakeScreenshotDemo;
import com.syntax.pages.DashboardPage;
import com.syntax.pages.loginPageWithFindBy;

public class LoginTestWithFindBy {

	public static void main(String[] args) {
		BaseClass.setUp();
		loginPageWithFindBy login = new loginPageWithFindBy();
		DashboardPage dashboard = new DashboardPage();
		
		login.userNameTextBox.sendKeys("Admin");
		login.passwordTextBox.sendKeys("Hum@nhrm123");
		login.loginBtn.click();
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
		
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenshots/HRMS/dashboard.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		String adminText = dashboard.welcomeAdmin.getText();
		System.out.println(adminText);
		BaseClass.tearDown();
	}

}
