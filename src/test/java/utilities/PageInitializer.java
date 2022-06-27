package utilities;

import pageFactory.CartPage;
import pageFactory.HomePage;
import pageFactory.ProductPage;

public class PageInitializer extends BaseClass{

	
	public static HomePage h;
	public static CartPage c;
	public static ProductPage p;
	
	
	public static void initialize() {
		h = new HomePage();
		c = new CartPage();
		p = new ProductPage();

	}
	
	
	
	
	
	
	
	
}//class
