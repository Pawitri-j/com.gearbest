package mainPK;

import org.junit.AfterClass;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseClass;
import utilities.CommonMethods;

public class MainHooks extends CommonMethods{

	
	@Before
	public static void setUp () {
		
		BaseClass.openBrowserAndGetURL();
	}
	
	
	
	@AfterClass
	public static void destroy(Scenario scenario) {
		
		if(scenario.isFailed()) {
			CommonMethods.takeScreenshot_fail("scenarioFail");
		}

		BaseClass.tearDown();
		
	}
	
	
	
	
	
	
	
	
	
}
