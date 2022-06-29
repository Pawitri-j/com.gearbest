package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BaseClass;
import utilities.CommonMethods;

public class MariaSteps extends CommonMethods {

	@Given("User clicks searchIcon")
	public void user_clicks_search_icon() {
		h.searchInput.click();
	
	}

   @Given("User is on Home Page and inputs {string}")
   public void user_is_on_home_page_and_inputs(String string) {
	   
	  h.searchByWord();
	   
   
}
   							////scenario 2/////
	@Then("Verify User should be able to see search list of searchItem")
	public void verify_user_should_be_able_to_see_search_list_of_search_item() {
		 h.searchWordInputSuggestionList();
	}
	
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
	   String currentUrl=BaseClass.getDriver().getCurrentUrl();
	   Assert.assertTrue(currentUrl.equals(BaseClass.getPropertyString("homePageURL")));
	}

	@Given("User clicks All button on searchBar")
	public void user_clicks_all_button_on_search_bar() {
	    h.clickingSearchallBtn();
	}

	@Given("User clicks on each Tab in Options list")
	public void user_clicks_on_each_tab_in_options_list()  {
	  h.searchByAllButtonListOptions();
	}

	@Then("Verify User should be able to navigate to correspondant tab page")
	public void verify_user_should_be_able_to_navigate_to_correspondant_tab_page() {
	   h.searchTitleverification();
	}	
	
}//class
