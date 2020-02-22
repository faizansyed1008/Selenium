package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.utilities.Driver;

public class SignInPage {
	
	public SignInPage() {

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "txtUsername")
	public WebElement userNameInputBox;

	@FindBy(id = "txtPassword")
	public WebElement passWordInputBox;

	@FindBy(id = "btnlogin")
	public WebElement loginButton;

}
