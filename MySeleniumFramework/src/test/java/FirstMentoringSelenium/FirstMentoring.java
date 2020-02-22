package FirstMentoringSelenium;

import org.junit.Test;
import org.openqa.selenium.By;

import test.utilities.BrowserUtils;
import test.utilities.Driver;

public class FirstMentoring {

	@Test
	public void firstpractice() {

		Driver.getDriver().get("http://google.com"); // hit url on the browser
        System.out.println(Driver.getDriver().getTitle()); // validates if your page title is correct
      	System.out.println(Driver.getDriver().getCurrentUrl()); // validate if you are landed on correct url
     // System.out.println(Driver.getDriver().getPageSource()); // print page source
      	
//======================================================================================================================================		
		Driver.getDriver().get("http://yahoo.com"); // hit url on the browser
		System.out.println(Driver.getDriver().getTitle()); // validates if your page title is correct
        System.out.println(Driver.getDriver().getCurrentUrl()); // validate if you are landed on correct url
     // System.out.println(Driver.getDriver().getPageSource()); // print page source
		
		Driver.getDriver().navigate().back();
		Driver.getDriver().close();
		
		
		
		
		
		
		
		
	}

}
