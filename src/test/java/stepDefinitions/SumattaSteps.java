package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class SumattaSteps extends CommonMethods {

//1. Scenario: Changing Language


	@When("Click on Language button")
	public void Click_on_Language_button() {

		h.languageButton.click();
	}

	@Then("Verify if user can change the language")
	public void Verify_if_user_can_change_the_language() {

		wait(1);
		waitForClickability(h.googleLanguageButton);
		h.googleLanguageButton.click();

		//wait(2);
		switchToFrame(h.googleFrame);

		actionClickInListByText(h.languageList, BaseClass.getPropertyString("language"));

		BaseClass.getDriver().switchTo().parentFrame();
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

		wait(2);
		System.out.println(h.googleLanguageButton.getText());
		Assert.assertTrue(h.googleLanguageButton.getText().contains(BaseClass.getPropertyString("language")));
	}

//2. Scenario: Changing currency

	@When("Click on Ship To\\(currency) button")
	public void click_on_ship_to_currency_button() {

		h.shipToButton.click();

	}

	@When("Select the currency")
	public void select_the_currency() {
		
		waitForClickability(h.currencyDropDownBox);
		h.currencyDropDownBox.click();
		clickSpecificElementInListByText(h.currencyList, BaseClass.getPropertyString("currency"));
	}

	@Then("Use should be able to change the currency")
	public void use_should_be_able_to_change_the_currency() {

		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		Assert.assertTrue(h.currencyShow.getText().contains(BaseClass.getPropertyString("currency")));
	}

//3. Scenario: Category tabs on the Home page

	@Then("Click on  each Tab under Category and each Tab should navigate to respective page")
	public void click_on_each_tab_under_category_and_each_tab_should_navigate_to_respective_page() {

			waitVisibilityOfList(h.categoryList);
		for (int i = 0; i < h.categoryList.size(); i++) {

			waitVisibilityOfList(h.categoryList);
			
			String categoryName = h.categoryList.get(i).getText();
			System.out.println(categoryName);

			waitVisibilityOfList(h.categoryList);
			waitForClickability(h.categoryList.get(i));
			h.categoryList.get(i).click();

			if (categoryName.equalsIgnoreCase(BaseClass.getPropertyString("promotionTab"))) {
				System.out.println(h.promotionBanner.getText());
				Assert.assertTrue(h.promotionBanner.getText().contains(categoryName));

			} else {

				String eachCategoryName = h.eachPageCategoryHeader.getText();
				System.out.println(eachCategoryName);

				Assert.assertTrue(categoryName.equalsIgnoreCase(eachCategoryName));
			}

		BaseClass.getDriver().navigate().back();

		}
	}

}
