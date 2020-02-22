package mySeleniumProjectTwo;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import test.utilities.BrowserUtils;
import test.utilities.Driver;

public class WindowHandling {
//WINDOW HANDLES======================================================================================================================//============	
	@Test
	public void windowHandles() {
		Driver.getDriver().get("https://demoqa.com/automation-practice-switch-windows/");
		Driver.getDriver().manage().window().maximize();
		// firstWindow
		Driver.getDriver().findElement(By.xpath("//*[@id=\"button1\"]")).click();
		// SecondWindow
		Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div[2]/button[2]")).click();
		// ThirdLink
		Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div[2]/button[3]")).click();

		System.out.println("Before Switching");
		System.out.println(Driver.getDriver().getTitle());
		//
		Set<String> ids = Driver.getDriver().getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childID = it.next();
		Driver.getDriver().switchTo().window(childID);
		//
		System.out.println("After Switching");
		System.out.println(Driver.getDriver().getTitle());
		//
		Driver.getDriver().switchTo().window(parentId);
		System.out.println("Switching Back To Parent");
		System.out.println(Driver.getDriver().getTitle());
	}
//==================WINDOWS HANDLES====================================================================================================/////////////

	@Test
	public void windowHandlesPractice() {
		Driver.getDriver().get("https://the-internet.herokuapp.com/");
		Driver.getDriver().manage().window().maximize();

		// firstWindow
		Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();
		// SecondWindow
		Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

		System.out.println("Before Switching");
		System.out.println(Driver.getDriver().getTitle());

		Set<String> ids = Driver.getDriver().getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childID = it.next();
		Driver.getDriver().switchTo().window(childID);

		System.out.println("After Switching");
		System.out.println(Driver.getDriver().getTitle());
		//
		Driver.getDriver().switchTo().window(parentId);
		System.out.println("Switching Back To Parent");
		System.out.println(Driver.getDriver().getTitle());
	}

//================================FRAME SCROLLING======================================================================================//========///////	
	@Test
	public void iFrameScrolling() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

//      1. Navigate to https://www.toolsqa.com/iframe-practice-page/
		Driver.getDriver().get("https://www.toolsqa.com/iframe-practice-page/");
		Driver.getDriver().manage().window().maximize();

//      2. close header accept
		Driver.getDriver().findElement(By.id("cookie_action_close_header")).click();

//      3. Scroll down to "Use these frames to practice your skills"
		WebElement scrollToElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/p[4]"));

		js.executeScript("arguments[0].scrollIntoView();", scrollToElement);

//      4. step into iFrame F2 
		Driver.getDriver().switchTo().frame("IF2");
		BrowserUtils.waitFor(3);

//      5. Click on "Droppable"
		Driver.getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[4]/a")).click();

//      6. Scroll down to target dropBox area

		WebElement inFrameScrollto = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/h1"));
		js.executeScript("arguments[0].scrollIntoView();", inFrameScrollto);
		BrowserUtils.waitFor(3);

//      7. Drag source to target

		WebElement dragMe = Driver.getDriver().findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement draggedTo = Driver.getDriver().findElement(By.xpath("//*[@id=\"droppable\"]"));

		BrowserUtils.dragAndDrop(dragMe, draggedTo);
		BrowserUtils.waitFor(3);

	}
//======================DATA TABLE=====================================================================================================//
	
//TEST 1========
	
	
	@Test
	public void dataTable() {
		Driver.getDriver().get("http://the-internet.herokuapp.com/tables");
		Driver.getDriver().manage().window().maximize();

		for (int numberOfRows = 1; numberOfRows <= 4; numberOfRows++) {

			for (int numberOfCol = 1; numberOfCol <= 5; numberOfCol++) {

				System.out.println(Driver.getDriver()
						.findElement(
								By.xpath("//*[@id=\"table1\"]/tbody/tr[" + numberOfRows + "]/td[" + numberOfCol + "]"))
						.getText());

			}
		}

	}
//TEST 2===============================================================================================================================//
	@Test
	public void dataTable2() {
		Driver.getDriver().get("http://the-internet.herokuapp.com/tables");
		Driver.getDriver().manage().window().maximize();

		for (int numberOfRows = 1; numberOfRows <= 4; numberOfRows++) {

			for (int numberOfCol = 1; numberOfCol <= 5; numberOfCol++) {

				System.out.println(Driver.getDriver()
						.findElement(
								By.xpath("//*[@id=\"table2\"]/tbody/tr[" + numberOfRows + "]/td[" + numberOfCol + "]"))
						.getText());

			}

		}
	}
}
