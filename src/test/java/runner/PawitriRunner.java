package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = { 
				"pretty", 
				"junit:target/JUnit/Pawitri_junit.xml",
				"html:target/HTML/Pawitri-html-reports.html"
				},
		features = "src/test/resources/featureFolder/Pawitri.feature",
		glue = "stepDefinitions",
		dryRun = true,
		monochrome = true
)













public class PawitriRunner {
	
}
