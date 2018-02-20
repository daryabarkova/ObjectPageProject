package by.dbarkova.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://e.mail.ru/messages/inbox/";

	@FindBy(id = "PH_user-email")
	private WebElement userAccountName;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getUserAccountName()
	{
		return userAccountName.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
}