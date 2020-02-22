package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.utilities.Driver;

public class landing_DashBoardPage {

	public landing_DashBoardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "panel_resizable_0_0")
	public WebElement QuickLunchPanel;

	@FindBy(id = "welcome")
	public WebElement WelcomeAdminDropDown;

	@FindBy(xpath = "//*[@id=\"welcome-menu\"]/ul/li[2]/a")
	public WebElement logOutButton;

}
