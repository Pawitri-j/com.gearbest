package stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class ArmeenaSteps extends CommonMethods {

	// 1. Scenario: Yellow Banner tabs navigate
	@Then("User click on each tabs on yellow banner menu. User should navigate to each page after clicking")
	public void user_click_on_each_tabs_on_yellow_banner_menu() {
//		
//		String homePageURL;
//		String currentTabURL;
		
		ArrayList<String> yellowBanner = new ArrayList<>(Arrays.asList("flash-sale", "app-exclusive", "new-products"));

		for (int i = 0; i < h.yellowTabList.size(); i++) {
		
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			System.out.println(h.yellowTabList.get(i).getText());
			h.yellowTabList.get(i).click();
			Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(yellowBanner.get(i)));

		}

	}

	// 2. Scenario: Social Media tabs are clickable
	@When("User should be able to click on each button for social media tab")
	public void user_should_be_able_to_click_on_each_button_for_social_media_tab() {

//		String homePageURL;
//		String currentTabURL;
//		
		ArrayList<String> socialMediasBanner = new ArrayList<>(Arrays.asList("facebook", "messenger", "youtube",
				"pinterest", "vk", "instragram", "twitter", "blog", "tumblr"));

		for (int i = 0; i < h.socialMediaButtonsList.size(); i++) {
	
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			System.out.println(h.socialMediaButtonsList.get(i).getText());

			h.socialMediaButtonsList.get(i).click();
			
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
			Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(socialMediasBanner.get(i)));

			BaseClass.getDriver().navigate().back();

		}

	}

	// 3. Scenario: Company Information links navigate
	@When("User should be able to click on each tabs. User should navigate to each page after clicking")
	public void user_should_be_able_to_click_on_each_tabs() {

//		String homePageURL;
//		String currentTabURL;
		
		for (int i = 0; i < h.companyInformationList.size(); i++) {

			String companyInformation = h.companyInformationList.get(i).getText();
			System.out.println(companyInformation);
			
			h.companyInformationList.get(i).click();
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
		
			if (companyInformation.contains("Top Brands")) {
				System.out.println(h.topBrandsPage.getText());
				Assert.assertTrue(h.topBrandsPage.getText().contains("Brands"));
			
			}else if (companyInformation.contains("Gearbest Official Blog")) {
				System.out.println(h.blogHeader.getText());
				Assert.assertTrue(h.blogHeader.getText().contains("New Gear"));
			}else {
				Assert.assertTrue(companyInformation.contains(h.companyInfoHeader.getText()));
				
			}
				
			BaseClass.getDriver().navigate().back();
		
		
		}
		
		
	}

}
