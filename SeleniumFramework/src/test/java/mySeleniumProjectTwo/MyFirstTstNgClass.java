package mySeleniumProjectTwo;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.utilities.BrowserUtils;
import test.utilities.Driver;

public class MyFirstTstNgClass {
	@BeforeClass
	public static void initCalculator() {
	}

	@BeforeTest
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");
		Driver.getDriver().get("https://phptravels.com/");
		Driver.getDriver().manage().window().maximize();
		BrowserUtils.waitFor(3);
	}

	@AfterTest
	public void afterEachTest() {
		System.out.println("This is exceuted after each Test");
	}

	@Parameters({ "pattern1", "pattern2" })
	@Test
	public void testSum(String firstPattern, String SecondPattern) {

		Driver.getDriver().findElement(By.xpath("//*[@id=\"ShopifyMainNav\"]/ul[1]/li[1]/a")).click();

		String objUserinfoDev = Driver.getDriver()
				.findElement(By.xpath(
						"//*[@id=\"Main\"]/section[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div"))
				.getAttribute("innerText");
		System.out.println(objUserinfoDev);
		String pattern1 = firstPattern;
		String pattern2 = SecondPattern;
		String email = getMatchedText(objUserinfoDev, pattern1);
		String password = getMatchedText(objUserinfoDev, pattern2);
		System.out.println(email);
		System.out.println(password);
		// 4. Navigate to 'https://www.phptravels.net/' by clicking on the button
		Driver.getDriver()
				.findElement(
						By.xpath("//*[@id=\"Main\"]/section[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div/a"))
				.click();
		// switch your window to the childWindow

		Set<String> ids = Driver.getDriver().getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childID = it.next();
		Driver.getDriver().switchTo().window(childID);
		BrowserUtils.waitFor(8);
		// 6. click on "MY ACCOUNT" and click on 'login'
		BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("(//*[@id=\"li_myaccount\"]/a)[2]")), 5)
				.click();
		Driver.getDriver().findElement(By.xpath("(//*[@id=\"li_myaccount\"]/ul/li[1]/a)[2]")).click();
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.nsg-button"))).click();
		// 7. sign in using Captured Credentials
		Driver.getDriver().findElement(By.name("username")).sendKeys(email);
		Driver.getDriver().findElement(By.name("password")).sendKeys(password);
//              try {
//                  Driver.getDriver().findElement(By.xpath("//*[@id=\"cookyGotItBtnBox\"]/div")).click();
//              } catch (Exception e) {
//                  System.out.println("Cookie Button Not Available");
//              }
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		WebElement scrollToElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"loginfrm\"]/button"));
		js.executeScript("arguments[0].scrollIntoView();", scrollToElement);
		BrowserUtils.waitFor(3);
		Driver.getDriver().findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();
		BrowserUtils.waitFor(3);
//            8. verify 'Hi, Demo User' on the page
		// Driver.getDriver().switchTo().frame("ym-native-frame");
		String validate = Driver.getDriver().findElement(By.xpath("//h3[@class='RTL']")).getText();
		Assert.assertTrue(validate.contains("Hi, Demo User"));
		Driver.getDriver().close();

	}

	public static String getMatchedText(String line, String pattern) {
		String result = null;
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			result = m.group(0);
		} else {
			result = "NO MATCHING USERNAME";
		}
		return result;
	}

	@Test
	public void testDivison() {
	}

//    @Test(expectedExceptions = Exception.class)
//    public void testDivisionException() throws Exception {
//
//    }
	@Test
	public void testEqual() {
	}

	@Parameters({ "number1", "number2", "sum" })
	@Test
	public void testAdd(int number1, int number2, int sum) {
		Assert.assertEquals(add(number1, number2), sum);
		System.out.println(add(number1, number2));
	}

	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "data one" }, { "data two" }, { "data three" }, { "data 4" }, { "data 5" } };
	}

	@Test(dataProvider = "data-provider")
	public void testMethod(String data) {
		System.out.println("Data is: " + data);
	}

	// COMMONS
//    @Test            Attaches a class or a method to become the part of the test.
//    @BeforeTest        Instructs the method to run before any test method related to the classes which are inside the <test> tag as per the <testng.xml> file.
//    @AfterTest        Halts a method from execution till all the test methods finish their execution. These methods belong to the classes defined in the <test> tag of <testng.xml> file.
//    @BeforeMethod    Allows a method to run before executing any of the @test annotated methods.
//    @AfterMethod    Allows a method to take off after all of the @test annotated methods finish their execution.
//    @BeforeClass    The method annotated with @BeforeClass gets executed once before the first test method of the current class.
//    @AfterClass        The method annotated with @AfterClass gets run once after finishing all the test methods in the current class.
//    @Parameters        You can use this annotation for passing the parameters to the test methods.
//    @DataProvider    It marks a method as a data source for the test. Every @DataProvider annotated method must always return the value as <Object[ ][ ]>. You can use it in any of the @Test annotated methods.
//    @BeforeGroups    It sets up the method to run before the first test method belonging to any of the groups involved in the execution.
//    @AfterGroups    It sets up the method to run after the execution of all the test methods belonging to any of the groups participating in the test.
//    @BeforeSuite    Any such method will get called before any of the suites runs from the test.
//    @AfterSuite        Any such method will stay its execution until all other methods in the current test suite get executed.
//    @Factory        You use it to execute any specific group of test cases with different values. It returns an array of test class objects as the <Object[ ]>.
//    @Listeners        You can use them with the test classes for the logging function.
	public static long add(long number1, long number2) {
		long results;
		results = number1 + number2;
		return results;
	}
}
