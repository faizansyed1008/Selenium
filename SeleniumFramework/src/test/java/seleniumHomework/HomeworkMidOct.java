package seleniumHomework;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import test.utilities.BrowserUtils;
import test.utilities.Driver;

public class HomeworkMidOct {

	@Test
	public void windowHandles() {

//Login=================================================================================================================================//		
		Driver.getDriver().get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
		Driver.getDriver().manage().window().maximize();

		Driver.getDriver().findElement(By.id("txtUsername")).click();
		BrowserUtils.waitFor(1);
		Driver.getDriver().findElement(By.id("txtUsername")).sendKeys("opensourcecms");

		Driver.getDriver().findElement(By.id("txtPassword")).click();
		BrowserUtils.waitFor(1);
		Driver.getDriver().findElement(By.id("txtPassword")).sendKeys("opensourcecms");
     	Driver.getDriver().findElement(By.id("btnLogin")).click();
     	
     	
//================================================================================================================================//
	
		
		String validate = Driver.getDriver().findElement(By.xpath("//*[@id=\"option-menu\"]/li[1]")).getText();
		Assert.assertTrue(validate.contains("Welcome Admin"));

		Driver.getDriver().findElement(By.xpath("//*[@id=\"admin\"]/a/span")).click();
		Driver.getDriver().findElement(By.xpath("//*[@id=\"option-menu\"]/li[1]")).isDisplayed();

		BrowserUtils.waitFor(3);

		Driver.getDriver().switchTo().frame("rightMenu");
		String varify = Driver.getDriver().findElement(By.id("genInfoHeading")).getText();
		Assert.assertTrue(varify.contains("General Information"));

		Driver.getDriver().navigate().back();

		Driver.getDriver().findElement(By.xpath("//*[@id=\"option-menu\"]/li[3]/a")).click();

		String logoutconfirm = Driver.getDriver().findElement(By.xpath("//*[@id=\"logInPanelHeading\"]")).getText();
		Assert.assertTrue(logoutconfirm.contains("LOGIN Panel"));

	}

}
