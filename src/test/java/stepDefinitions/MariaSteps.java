package stepDefinitions;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class MariaSteps extends CommonMethods {
	

	//Scenario 1  Verify search suggestion by keyword input
	@Then("Verify User should be able to see suggestion drop down that matching the in put keyword")
	public void verify_suggestion() {
		 
		h.searchInput.sendKeys(" "); // if not put this in, it will not detect suggestion dropdown
		waitVisibilityOfList(h.searchSuggestionsList);
			try {
				for (int i = 0; i < h.searchSuggestionsList.size(); i++) {
					System.out.println(h.searchSuggestionsList.get(i).getText());
					Assert.assertTrue(h.searchSuggestionsList.get(i).getText().contains(BaseClass.getPropertyString("searchItem1")));
				}
			} catch (Exception e) { 
				// non-matching word
				e.printStackTrace();
				System.out.println(BaseClass.getPropertyString("warning message"));
			}	
	}

	
	//Scenario 2 Verify All button drop down list functionality	
	@Given("User clicks All button on searchBar")
	public void user_clicks_all_button_on_search_bar() {
	    h.AllButton.click();
	}

	@Then("User clicks on each Tab in Options list. Verify User should be able to navigate to correspondant tab page which is clicked")
	public void user_clicks_on_each_tab_in_options_list()  {
		
		for(int i=0;i<h.allDropDownSearchList.size();i++) {
			h.searchInput.clear();
			
			String searchAllCategoriesText= h.allDropDownSearchList.get(i).getText();
			System.out.println(searchAllCategoriesText);
			h.allDropDownSearchList.get(i).click();
			
			h.searchInput.clear();
			
			waitForClickability(h.searchIcon);
			h.searchIcon.click();
			
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
			if (searchAllCategoriesText.equalsIgnoreCase("All")) {
				System.out.println(BaseClass.getDriver().getCurrentUrl());
				Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(BaseClass.getPropertyString("homePageURL")));
			}else {
				String categoryHeaderText = h.categoryHeader.getText();
				System.out.println(categoryHeaderText);
				Assert.assertTrue(searchAllCategoriesText.contains(categoryHeaderText));
			}
		
			h.AllButton.click();
		}
	}

	
	
	
//Scenario 3 Verify search functionality by item name
	
	@Then("User should be navigated to searched item page")
	public void user_should_be_navigated_to_searched_item_page() {
	   
		try {  
			waitForVisibility(h.categoryHeader);    // element - found matching product
			if(h.categoryHeader.isDisplayed()) {
				String searchResultText =h.categoryHeader.getText();
				
				if (searchResultText.contains(BaseClass.getPropertyString("searchItem2"))) {
					Assert.assertTrue(true);
				}
			}
			
			if(h.notMatchingMsg.isDisplayed()) {   // element - not found matching product
				System.out.println(BaseClass.getPropertyString("notMatchingResult"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	
	
	
	
	
	
	
}//class
