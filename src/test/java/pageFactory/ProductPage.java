package pageFactory;

import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ProductPage extends CommonMethods{

public ProductPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);	
		
	}
	



	
	
}//class
