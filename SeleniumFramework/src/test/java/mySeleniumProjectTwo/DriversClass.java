package mySeleniumProjectTwo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriversClass {

	static String path = System.getProperty("user.dir");
	static WebDriver myFirstWebDriver;

	@Test
	public void test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");

		myFirstWebDriver = new ChromeDriver();

//		myFirstWebDriver.get("https://www.youtube.com");
//		myFirstWebDriver.manage().window().maximize();

		System.out.println(myFirstWebDriver.getTitle()); //// gets current page title
		System.out.println(myFirstWebDriver.getCurrentUrl()); // gets page Url
		System.out.println("============================================");
		System.out.println(myFirstWebDriver.getPageSource()); // printing page source
		System.out.println("============================================");

		myFirstWebDriver.get("http://demo.automationtesting.in/Index.html");
		myFirstWebDriver.manage().window().maximize();
//		myFirstWebDriver.navigate().back();// navigating back to previous page
//		myFirstWebDriver.navigate().forward();// navigating forward to next page if applicable

		myFirstWebDriver.findElement(By.id("email")).sendKeys("faizsyed1008@gmail.com");
        myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.id("enterimg")).click();
        myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("faizan");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("syed");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Whitehouse");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("faizsyed1008@gmail.com");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("8007009000");
	    myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]")).click();
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"checkbox1\"]")).click();
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"Skills\"]")).sendKeys("Java");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.id("msdd")).click();
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
		
		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).click();

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"countries\"]")).sendKeys("Pakistan");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		myFirstWebDriver.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[11]")).click();
		
		myFirstWebDriver.findElement(By.xpath("//*[@id=\"yearbox\"]")).sendKeys("1991");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"))
				.sendKeys("October");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.xpath("//*[@id=\"daybox\"]")).sendKeys("8");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.id("firstpassword")).sendKeys("pakistan");
		myFirstWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myFirstWebDriver.findElement(By.id("secondpassword")).sendKeys("pakistan");
	}
}
