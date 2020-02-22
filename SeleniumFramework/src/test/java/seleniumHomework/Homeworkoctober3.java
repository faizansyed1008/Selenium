package seleniumHomework;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.utilities.ConfigurationReader;
import test.utilities.Driver;

public class Homeworkoctober3 {
	
	@Test
	public void test1() throws InterruptedException {

     	
		System.out.println(Driver.getDriver().getTitle()); //// gets current page title
		Driver.getDriver().manage().window().maximize();
		
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		System.out.println(Driver.getDriver().getCurrentUrl()); // gets page Url
		System.out.println("============================================");
		
		System.out.println(Driver.getDriver().getPageSource()); // printing page source
		System.out.println("============================================");

		Driver.getDriver().get(ConfigurationReader.getProperty("url2"));
		
		Driver.getDriver().manage().window().maximize();
		
		Driver.getDriver().findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();

		Driver.getDriver().findElement(By.id("username")).sendKeys("faizsyed1008");

		Driver.getDriver().findElement(By.id("password")).sendKeys("TechCircle199");
		
		Driver.getDriver().findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		
		Driver.getDriver().findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")).click();
	}
}