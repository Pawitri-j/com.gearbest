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

	// Armeena 1. Scenario: Yellow Banner tabs navigate
	@Then("User click on each tabs on yellow banner menu. User should navigate to each page after clicking")
	public void user_click_on_each_tabs_on_yellow_banner_menu() {

		
//		ArrayList<String> yellowBanner = new ArrayList<>(Arrays.asList("flash-sale", "app-exclusive", "new-products"));

		for (int i = 0; i < h.yellowTabList.size(); i++) {
		
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

			h.yellowTabList.get(i).click();
			Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(Constants.yellowBanner.get(i)));

		}

	}

	//  Armeena 2. Scenario: Social Media tabs are clickable
	@When("User should be able to click on each button for social media tab")
	public void user_should_be_able_to_click_on_each_button_for_social_media_tab() {

		for (int i = 0; i < h.socialMediaButtonsList.size(); i++) {

			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
			
			waitVisibilityOfList(h.socialMediaButtonsList);
			waitForClickability(h.socialMediaButtonsList.get(i));
			h.socialMediaButtonsList.get(i).click();
			
		
			BaseClass.getDriver().navigate().refresh(); // otherwise it will detect the wrong URL
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
			System.out.println( BaseClass.getDriver().getCurrentUrl()+"......"+Constants.socialMediasBanner.get(i));
			Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(Constants.socialMediasBanner.get(i)));
 
			BaseClass.getDriver().navigate().back();
			
		}

	}

	//  Armeena 3. Scenario: Company Information links navigate
	@When("User should be able to click on each tabs. User should navigate to each page after clicking")
	public void user_should_be_able_to_click_on_each_tabs() {
		
		for (int i = 0; i < h.companyInformationList.size(); i++) {

			BaseClass.getDriver().navigate().refresh();
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			String companyInformation = h.companyInformationList.get(i).getText();
			System.out.println(companyInformation);

			wait(2);
			waitForClickability(h.companyInformationList.get(i));
			h.companyInformationList.get(i).click();
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
			
			if (companyInformation.contains(BaseClass.getPropertyString("Tab1"))) {
				System.out.println(h.topBrandsPage.getText());
				Assert.assertTrue(h.topBrandsPage.getText().contains(BaseClass.getPropertyString("socialMedia1")));
			
			}else if (companyInformation.contains(BaseClass.getPropertyString("Tab2"))) {
				System.out.println(h.blogHeader.getText());
				Assert.assertTrue(h.blogHeader.getText().contains(BaseClass.getPropertyString("socialMedia2")));
			}else {
				System.out.println(companyInformation);
				Assert.assertTrue(companyInformation.contains(h.companyInfoHeader.getText()));
				
			}
				
			BaseClass.getDriver().navigate().back();
		
		
		}
		
		
	}

}
