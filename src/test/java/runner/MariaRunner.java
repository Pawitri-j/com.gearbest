package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = { 
				"pretty", 
				"junit:target/JUnit/Maria_junit.xml",
				"html:target/HTML/Maria-html-reports.html"
				},
		features = "src/test/resources/featureFolder/Maria.feature",
		glue = "stepDefinitions",
		dryRun = false,
				//tags="@SmokeTest",
		monochrome = true)
public class MariaRunner {

}
