package step_definitions;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SignInPage;
import pages.landing_DashBoardPage;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;



public class stepDefinitions {

	SignInPage signin = new SignInPage();
	landing_DashBoardPage landingPage = new landing_DashBoardPage();

	@Given("^opening website$")
	public void opening_website() {

		Driver.getDriver().get(ConfigurationReader.getProperty("URL1"));
	}

	@When("^loging in with username$")
	public void loging_in_with_username() {

		signin.userNameInputBox.sendKeys(ConfigurationReader.getProperty("username"));
		signin.passWordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
		signin.loginButton.click();

//		Driver.getDriver().findElement(By.id("txtUsername")).sendKeys(ConfigurationReader.getProperty("userName"));
//		Driver.getDriver().findElement(By.id("txtPassword")).sendKeys(ConfigurationReader.getProperty("passWord"));
//		Driver.getDriver().findElement(By.id("btnLogin")).click();

	}

	@Then("^verifying logged in$")
	public void verifying_logged_in() {

		landingPage.QuickLunchPanel.isDisplayed();

	}

	@Then("^logout$")
	public void logout() throws InterruptedException {

		landingPage.WelcomeAdminDropDown.click();
		Thread.sleep(3000);
		landingPage.logOutButton.click();

	}
}
