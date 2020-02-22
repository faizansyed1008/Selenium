package mySeleniumProjectTwo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import test.utilities.ConfigurationReader;
import test.utilities.Driver;

public class CustomXpath {

	@Before
	public void beforeMethod() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url3"));
//		Driver.getDriver().get(ConfigurationReader.getProperty("url4"));
	}

	@Test
	public void customXpathSendKeys() {

		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("searchbar"))).sendKeys("Blouse");
		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("searching"))).click();
		System.out.println(
				Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("results"))).isDisplayed());

	}
//	@Test
//	public void radioButton() {
//
//		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("checkbox"))).click();
//
//		Boolean firstcheckbox = Driver.getDriver()
//				.findElement(By.xpath(ConfigurationReader.getProperty("firstcheckbox"))).isSelected();
//		Boolean secondcheckbox = Driver.getDriver()
//				.findElement(By.xpath(ConfigurationReader.getProperty("secondcheckbox"))).isSelected();
//
//		// checkbox 1
//		if (firstcheckbox) {
//			System.out.println("First Checkbox already been checked!");
//		} else {
//			Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("firstCheckbox"))).click();
//			System.out.println("Fist Checkbox just been checked");
//		}
//
//		// checkbox 2
//		if (secondcheckbox) {
//			System.out.println("Second Checkbox already been checked!");
//		} else {
//			System.out.println("Second Checkbox just been checked");
//			Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("secondCheckbox"))).click();

	@After
	public void closingWeb() {

		Driver.closeDriver();

	}
}
