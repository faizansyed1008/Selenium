package mySeleniumProjectTwo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import test.utilities.BrowserUtils;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

public class ArrayclassAndmore {

	@Before
		public void beforeMethod() {
		Driver.getDriver().get(ConfigurationReader.getProperty("URL"));

		Driver.getDriver().manage().window().maximize();
	}
//
//	@Test
//	public void arrayListExample() {
//		// Search for dress on search input
//		Driver.getDriver().findElement(By.id("search_query_top")).sendKeys("Dress");
//
//		// Click Search
//		Driver.getDriver().findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
//		
//		// verify you're on results page
//		String resultsPageUniqueid = Driver.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]"))
//				.getText();
//
//		Assert.assertTrue(resultsPageUniqueid.contains("results have been found"));
//
//		// preConditionalProducts we are looking for to add in our cart
//
//		String[] requiredTextIn = { "Summer", "Dress", "In stock" };
//
//		// List
//		List<WebElement> products = Driver.getDriver().findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
//
//		for (int i = 0; i < products.size(); i++) {
//
//			String name = products.get(i).getText();
//
//			System.out.println(name + " -- " + i);
//
//		if (name.contains(requiredTextIn[0]) && name.contains(requiredTextIn[1])
//					&& name.contains(requiredTextIn[2])) {
//
//		BrowserUtils.hover(Driver.getDriver().findElements(By.xpath("//span[@class=\"available-now\"]")).get(i));
//		
//		Driver.getDriver().findElements(By.xpath("//a[@class=\"button ajax_add_to_cart_button btn btn-default\"]")).get(i).click();
//		BrowserUtils.waitFor(3);
//		Driver.getDriver().findElement(By.xpath("//span[@title=\"Continue shopping\"]")).click();
//		BrowserUtils.waitFor(3);
//			
//			} // ifElse ends
//		} // forLoop ends
//	}// end of Method

	// ActionClass
	@Test
	public void ActionClass() {

		Actions actions = new Actions(Driver.getDriver());

		// hoverOver
		BrowserUtils.hover(Driver.getDriver().findElement(By.xpath("//a[@title=\"Women\"]")));

		BrowserUtils.waitFor(2);

		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//a[@title=\"T-shirts\"])[1]")).isDisplayed());

		// drag and drop-- http://the-internet.herokuapp.com/
		Driver.getDriver().get("https://demoqa.com/droppable/");

		WebElement source = Driver.getDriver().findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement target = Driver.getDriver().findElement(By.xpath("//*[@id=\"droppable\"]"));

		BrowserUtils.waitFor(2);

		actions.dragAndDrop(source, target).perform();

		BrowserUtils.waitFor(2);

		// DoubleClick

		Driver.getDriver().findElement(By.xpath("//*[@id=\"menu-top\"]/li[4]/a")).click();

		actions.doubleClick(Driver.getDriver().findElement(By.id("doubleClickBtn"))).perform();

		System.out.println(Driver.getDriver().switchTo().alert().getText());

		Driver.getDriver().switchTo().alert().accept();

	}

}
