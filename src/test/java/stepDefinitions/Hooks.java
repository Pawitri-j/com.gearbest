package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;
import utilities.CommonMethods;

public class Hooks extends CommonMethods {

	
	@Before
	public static void setUp () {
		
		BaseClass.openBrowserAndGetURL();
	}
	
	
	
//	@After
//	public static void destroy() {
//		
//		BaseClass.tearDown();
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
}
