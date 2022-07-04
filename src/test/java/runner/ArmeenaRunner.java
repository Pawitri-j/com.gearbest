package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"pretty",
				"junit:target/JUnit/Armeena_junit.xml",
				"html:target/HTML/Armeena-html-reports.html"
		},
		
		features = "src/test/resources/featureFolder/Armeena.feature",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true
		
		)


public class ArmeenaRunner {

}
