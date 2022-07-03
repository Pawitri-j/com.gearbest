package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.CommonMethods;

public class MariaSteps extends CommonMethods {
	

	//Scenario 1  Verify search functionality by keyword input
	@Then("Verify User should be able to see suggestion drop down that matching the in put keyword")
	public void verify_suggestion() {
		 h.searchWordInputSuggestionList();
	}

	
	//Scenario 2 Verify All button drop down list functionality
	
	@Given("User clicks All button on searchBar")
	public void user_clicks_all_button_on_search_bar() {
	    h.clickingSearchallBtn();
	}

	@And("User clicks on each Tab in Options list")
	public void user_clicks_on_each_tab_in_options_list()  {
	  h.searchByAllButtonListOptions();
	}

	@Then("Verify User should be able to navigate to correspondant tab page which is clicked")
	public void verify_user_should_be_able_to_navigate_to_correspondant_tab_page_which_is_clicked() {
	 
	  // h.searchTitleverification();
		Assert.assertTrue(h.searchAllOptionHeader.isDisplayed());
	}	
	
	
	
	
//Scenario 3 Verify search functionality by item name
	
	@Then("User should be navigated to searched item page")
	public void user_should_be_navigated_to_searched_item_page() {
	   h.verifyItemsPage();
	}

	
	
	
	
	
	
	
}//class
