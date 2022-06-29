package stepDefinitions;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;

public class ArmeenaSteps extends CommonMethods {

	@Given("User on homePage")
	public void user_on_home_page() {
		
		h.checkHomePageURL();
	
	}

	@When("User click on each tabs on yellow banner menu.")
	public void user_click_on_each_tabs_on_yellow_banner_menu() {
	
		String homePageURL;
		String currentTabURL;
		
		for(int i = 0; i < h.yellowTabList.size();i++) {
				
				homePageURL = BaseClass.getDriver().getCurrentUrl();
		
				System.out.println(homePageURL);
				
				h.yellowTabList.get(i).click();
				
				currentTabURL = BaseClass.getDriver().getCurrentUrl();
				System.out.println(currentTabURL);
				
				Assert.assertFalse(homePageURL.equals(currentTabURL));
				
			}
	}

	@Then("User should navigate to each page after clicking")
	public void user_should_navigate_to_each_page_after_clicking() {
	   
	}

	@When("User should be able to click on each buttons")
	public void user_should_be_able_to_click_on_each_buttons() {
		
		String homePageURL;
		String currentTabURL;
		
		for(int i = 0; i < h.socialMediaButtonsList.size();i++) {
				
				homePageURL = BaseClass.getDriver().getCurrentUrl();
				System.out.println(homePageURL);
				
				h.socialMediaButtonsList.get(i).click();
				
				currentTabURL = BaseClass.getDriver().getCurrentUrl();
				System.out.println(currentTabURL);
				
				Assert.assertFalse(homePageURL.equals(currentTabURL));
				
			}
	}

	@When("User should be able to click on each tabs")
	public void user_should_be_able_to_click_on_each_tabs() {
	   
		String homePageURL;
		String currentTabURL;
		
		for(int i = 0; i < h.companyInformationLists.size();i++) {
		
				homePageURL = BaseClass.getDriver().getCurrentUrl();
				System.out.println(homePageURL);
				
				h.companyInformationLists.get(i).click();
				
				currentTabURL = BaseClass.getDriver().getCurrentUrl();
				System.out.println(currentTabURL);
				Assert.assertFalse(homePageURL.equals(currentTabURL));
				
			}
		
	}

	
	
	
	}
