package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = { 
				"pretty", 
				"junit:target/JUnit/Alip_junit.xml",
				"html:target/HTML/Alip-html-reports.html"
				},
		features = "src/test/resources/featureFolder/Alip.feature",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true
)












public class AlipRunner {

}
