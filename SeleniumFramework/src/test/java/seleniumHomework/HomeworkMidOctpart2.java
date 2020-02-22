package seleniumHomework;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import test.utilities.BrowserUtils;
import test.utilities.Driver;

public class HomeworkMidOctpart2 {

	@Test
    public void navigate() {
//      1. Navigate to https://phptravels.com/
        Driver.getDriver().get("https://phptravels.com/");
        Driver.getDriver().manage().window().maximize();
        BrowserUtils.waitFor(3);

//      2. Click tab 'Demo' and Navigate to the page
        Driver.getDriver().findElement(By.xpath("//*[@id=\"ShopifyMainNav\"]/ul[1]/li[1]/a")).click();

//      3. Capute the Username and Password of 'Homepage Front-End'

//        String username = Driver.getDriver().findElement(By.xpath(
//                "//*[@id=\"Main\"]/section[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div/text()[1]"))
//                .getText();
//        String password = Driver.getDriver().findElement(By.xpath(
//                "//*[@id=\"Main\"]/section[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div/strong[2]"))
//                .getText();
//        System.out.println(
//                "Homepage Front-end Username is: " + username + "\nHomepage Front-end Password is: " + password);

        String objUserinfoDev = Driver.getDriver()
                .findElement(By.xpath(
                        "//*[@id=\"Main\"]/section[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div"))
                .getAttribute("innerText");

        System.out.println(objUserinfoDev);

        String pattern1 = "\\w+@\\w+\\.\\w{3}";
        String pattern2 = "[^ ]*$";

        String email = getMatchedText(objUserinfoDev, pattern1);
        String password = getMatchedText(objUserinfoDev, pattern2);

        System.out.println(email);
        System.out.println(password);

        
//    4. Navigate to 'https://www.phptravels.net/' by clicking on the button
        Driver.getDriver()
                .findElement(
                        By.xpath("//*[@id=\"Main\"]/section[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div/a"))
                .click();

//    5. switch your window to the childWindow
        Set<String> ids = Driver.getDriver().getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childID = it.next();
        Driver.getDriver().switchTo().window(childID);
        BrowserUtils.waitFor(8);

//    6. click on "MY ACCOUNT" and click on 'login'
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("(//*[@id=\"li_myaccount\"]/a)[2]")), 5)
                .click();
        Driver.getDriver().findElement(By.xpath("(//*[@id=\"li_myaccount\"]/ul/li[1]/a)[2]")).click();
        // new WebDriverWait(driver,
        // 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.nsg-button"))).click();

//    7. sign in using Captured Credentials
        Driver.getDriver().findElement(By.name("username")).sendKeys(email);
        Driver.getDriver().findElement(By.name("password")).sendKeys(password);

//        try {
//            Driver.getDriver().findElement(By.xpath("//*[@id=\"cookyGotItBtnBox\"]/div")).click();
//        } catch (Exception e) {
//            System.out.println("Cookie Button Not Available");
//        }

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement scrollToElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"loginfrm\"]/button"));
        js.executeScript("arguments[0].scrollIntoView();", scrollToElement);

        BrowserUtils.waitFor(3);

        Driver.getDriver().findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();
        BrowserUtils.waitFor(3);
//    8. verify 'Hi, Demo User' on the page    
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
}
