package runners;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		plugin = { "pretty",
				   "html:target/default-cucumber-reports", 
				   "json:target/cucumber.json" 
        },

		
		features = "src/test/java/feature", 
		glue = "step_definitions",
//        dryRun = true,
		tags = "@testingTech"

)

public class CukesRunner {
}
