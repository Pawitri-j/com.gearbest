package mainPK;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = { 
				"pretty", 
				"junit:target/JUnit/Main_junit.xml",
				"html:target/HTML/Main-html-reports.html"
				}
		,features = "src/test/resources/featureFolder"
		,glue = {"mainPK"}
		,dryRun = false
		,monochrome = true
		// ,tags= "@Armeena"
		
		
		)



public class MainRunner {

}
