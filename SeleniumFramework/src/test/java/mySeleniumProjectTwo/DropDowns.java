package mySeleniumProjectTwo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import test.utilities.BrowserUtils;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

public class DropDowns {

	@Before
	public void BeforeMethod() {
		Driver.getDriver().get(ConfigurationReader.getProperty("DropdownUrl"));
//		Driver.getDriver().get(ConfigurationReader.getProperty("Url5"));
//     	Driver.getDriver().get(ConfigurationReader.getProperty("Url6"));

		Driver.getDriver().manage().window().maximize();
		BrowserUtils.waitFor(2);
	}

	@Test
	public void staticDropDown() {

		Select staticDropDown = new Select(
				Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("Dropdownlist1"))));
		staticDropDown.selectByIndex(3);
		BrowserUtils.waitFor(3);
		staticDropDown.selectByValue("AED");
		BrowserUtils.waitFor(3);
		staticDropDown.selectByVisibleText("INR");
	}

	@Test
	public void dropAndSelect() {

		Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("DropList"))).click();
		BrowserUtils.waitFor(3);

		int number = 1;

		while (number <= 4) {
			Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("Dropselect"))).click();
			number++;
		}
		BrowserUtils.waitFor(3);
		Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("Addpassenger"))).click();

	}

	@Test
	public void dynamicDropDowns() {

		Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("Departure"))).click();
		BrowserUtils.waitFor(3);

		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("DepartureAirport"))).click();
		

		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("ArrivalAirport"))).click();
		
	}

//	@Test
//	public void autoSuggestionDropDown() {
//		
//		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("departureAirportField"))).click();
//		BrowserUtils.waitFor(2);
//		
//		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("departureField"))).sendKeys("new york");
//		BrowserUtils.waitFor(2);
//		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("departureAirport"))).click();
//		
////Arrival airport=====================================================================================================	
//		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("arrivalAirportField"))).click();
//		BrowserUtils.waitFor(2);
//		
//		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("arrivalField"))).sendKeys("lahore");
//		BrowserUtils.waitFor(3);
//		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("arrivalAirport"))).click();
//		
//	}

//    @Test
//	public void alertMethodAssert() {
//		
//		
//		Driver.getDriver().findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
//		BrowserUtils.waitFor(2);
//		System.out.println(Driver.getDriver().switchTo().alert().getText());
//		Driver.getDriver().switchTo().alert().accept();
//		
//		
//		
//		Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).getText(), "You pressed Ok!");
//	}

//	@Test
//	public void aarayListMethod() {
//		
//		
//		 ArrayList<WebElement> ul= (ArrayList<WebElement>) Driver.getDriver().findElement(By.xpath("//*[@id=\"files\"]"));
//       List<WebElement> ul = (List<WebElement>) Driver.getDriver().findElement(By.tagName("optgroup"));
//
//		
//		 WebElement cntry = Driver.getDriver().findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"));
//	     List<WebElement> options = cntry.findElements(By.tagName(""));
//	     Iterator<WebElement> cntryitr = options.iterator();
//	     while (cntryitr.hasNext()) {
//	     System.out.println(cntryitr.next().getAttribute("Value"));
//	     System.out.println(cntryitr.next().getText());
//	   }
//	
//	
//}

	@After
	public void afterMethod() {

	}
}
