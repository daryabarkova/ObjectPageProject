package by.dbarkova.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.dbarkova.steps.Steps;

public class LoginTest {

	private Steps steps;
	private final String USERNAME = "bdw89";
	private final String PASSWORD = "2705223";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		}

	@Test
	public void authorizationPositive() throws InterruptedException{
		steps.loginMailRu(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn("bdw89@mail.ru"));
	}
	
	
//	{
//		steps.loginGithub(USERNAME, PASSWORD);
//		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
//		Assert.assertTrue(steps.currentRepositoryIsEmpty());
//		// do not use lots of asserts
//	}
//
//	@Test(description = "Login to Github")
//	public void oneCanLoginGithub()
//	{
//		steps.loginGithub(USERNAME, PASSWORD);
//		Assert.assertTrue(steps.isLoggedIn(USERNAME));
//	}
//
	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
