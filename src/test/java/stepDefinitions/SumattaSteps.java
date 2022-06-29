package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class SumattaSteps extends CommonMethods{

//------1--------

	@Given("User on home page9")
	public void user_on_home_page9() {
	    
		h.checkHomePageURL();
	}
	
	
	@When("Click View more button9")
	public void click_view_more_button9() {
	    
		
	}
	
	
	@Then("User should be able to see more products after clicking View more button9")
	public void user_should_be_able_to_see_more_products_after_clicking_view_more_button9() {
	
	h.languageButton.click();
	
	h.googleLanguageButton.click();
	
	switchToFrame(h.googleFrame);
	
	actionClickInListByText(h.languageList, "Thai");

	BaseClass.getDriver().switchTo().parentFrame();
	BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
	
	System.out.println(h.googleLanguageButton.getText());
	Assert.assertTrue(h.googleLanguageButton.getText().contains("Thai"));
	}


//----------2---------------
	

	@When("Click on Ship To\\(currency) button10")
	public void click_on_ship_to_currency_button10() {
	  
		h.shipToButton.click();
		
	}


	@When("Select the currency")
	public void select_the_currency() {
		
		h.currencyDropDownBox.click();
		clickSpecificElementInListByText(h.currencyList, "CAD");
	}



	@Then("Use should be able to change the currency10")
	public void use_should_be_able_to_change_the_currency10() {
			
		Assert.assertTrue(h.currencyShow.getText().contains("CAD"));	
	}


//---------------3----------
	

	@Then("Click on  each Tab under Category and each Tab should navigate to respective page11")
	public void click_on_each_tab_under_category_and_each_tab_should_navigate_to_respective_page() {
	
		hover(h.categoryButton);
		
		for(int i =0; i< h.categoryList.size();i++) {
			
			String categoryName = h.categoryList.get(i).getText();
			System.out.println(categoryName);
			
			waitVisibilityOfList(h.categoryList);
			waitForClickability(h.categoryList.get(i));
			h.categoryList.get(i).click();
			
			if(categoryName.equalsIgnoreCase("Gearbest Promotion")) {
				System.out.println(h.promotionBanner.getText());
				Assert.assertTrue(h.promotionBanner.getText().contains(categoryName));
				
			}else {
			
				String eachCategoryName = h.eachPageCategoryHeader.getText();
				System.out.println(eachCategoryName);
				
				Assert.assertTrue(categoryName.equalsIgnoreCase(eachCategoryName));
			}
			
			hover(h.categoryButton);
			
		}
	}



	
	
	
	
	
	
	
	
	
	
	
}
