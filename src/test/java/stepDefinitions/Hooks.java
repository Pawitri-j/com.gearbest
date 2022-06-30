package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseClass;
import utilities.CommonMethods;

public class Hooks extends CommonMethods {

	
	@Before
	public static void setUp () {
		
		BaseClass.openBrowserAndGetURL();
	}
	
	
	
	@After
	public static void destroy(Scenario scenario) {
		
		if(scenario.isFailed()) {
			CommonMethods.takeScreenshot_fail("scenarioFail");
		}

		BaseClass.tearDown();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
