package stepDefinitions;

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

		String homePageURL;
		String currentTabURL;

		for (int i = 0; i < h.yellowTabList.size(); i++) {

			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			homePageURL = BaseClass.getDriver().getCurrentUrl();

			System.out.println(homePageURL);

			h.yellowTabList.get(i).click();

			currentTabURL = BaseClass.getDriver().getCurrentUrl();
			System.out.println(currentTabURL);

			Assert.assertFalse(homePageURL.equals(currentTabURL));


		}
	}

	// 2. Scenario: Social Media tabs are clickable
	@When("User should be able to click on each button for social media tab")
	public void user_should_be_able_to_click_on_each_button_for_social_media_tab() {

		String homePageURL;
		String currentTabURL;

		for (int i = 0; i < h.socialMediaButtonsList.size(); i++) {

			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
			homePageURL = BaseClass.getDriver().getCurrentUrl();
			System.out.println(homePageURL);

			//wait(2);
			waitForClickability(h.socialMediaButtonsList.get(i));
			h.socialMediaButtonsList.get(i).click();

			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			currentTabURL = BaseClass.getDriver().getCurrentUrl();
			System.out.println(currentTabURL);

			Assert.assertFalse(homePageURL.equals(currentTabURL));
			
			BaseClass.getDriver().navigate().back();

		}
	}

	// 3. Scenario: Company Information links navigate
	@When("User should be able to click on each tabs. User should navigate to each page after clicking")
	public void user_should_be_able_to_click_on_each_tabs() {

		String homePageURL;
		String currentTabURL;

		for (int i = 0; i < h.companyInformationLists.size(); i++) {
			
			BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			
			homePageURL = BaseClass.getDriver().getCurrentUrl();
			System.out.println(homePageURL);

			h.companyInformationLists.get(i).click();

			currentTabURL = BaseClass.getDriver().getCurrentUrl();
			System.out.println(currentTabURL);
			Assert.assertFalse(homePageURL.equals(currentTabURL));

		}

	}

}
