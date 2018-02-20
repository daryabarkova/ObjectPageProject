package by.dbarkova.steps;

import by.dbarkova.driver.DriverSingleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.dbarkova.pages.LoginPage;
import by.dbarkova.pages.MainPage;

public class Steps
{
	private WebDriver driver;

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void loginMailRu(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) throws InterruptedException
	{
		MainPage mainPage = new MainPage(driver);
		//Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PH_user-email")));

		String actualUserName = mainPage.getUserAccountName();
		System.out.println(actualUserName);
		
		return username.equalsIgnoreCase(actualUserName);
	}

}
