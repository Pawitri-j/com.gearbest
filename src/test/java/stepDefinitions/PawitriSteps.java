package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class PawitriSteps extends CommonMethods {

	//1. Scenario: Cart button

	@Given("User is navigated to Home page")
	public void User_is_on_Home_page() {

		h.checkHomePageURL();

	}

	@Then("Click each tab on yellow banner. User should navigate to the Cart page after clicking the Cart icon button")
	public void user_should_navigate_to_the_cart_page_after_clicking_the_cart_icon_button() {

		waitVisibilityOfList(h.yellowTabList);

		// loop click cart icon from different pages
		for (int i = 0; i < h.yellowTabList.size(); i++) {

			h.yellowTabList.get(i).click();

			h.cartIconButton.click();
			CommonMethods.waitForVisibility(c.cartProcessTab);

			Assert.assertTrue(c.cartProcessTab.isDisplayed());

			// BaseClass.getDriver().navigate().refresh();
			c.gearBestLogoCartPage.click();

		}
	}

//2. Scenario: Changing quantity of product in the Cart

	@Given("Click the category tab")
	public void click_tab_on_home_page_to_product_page() {

		clickSpecificElementInListByText(h.categoryList, BaseClass.getPropertyString("chosenTab"));
	}

	@When("Click the chosen product and click Add to cart button")
	public void click_the_chosen_product_and_click_add_to_cart_button() {

		waitVisibilityOfList(p.productList);
		clickValueFromListByIndex(p.productList, BaseClass.getPropertyInteger("index1"));

		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		wait(2);
		waitForClickability(p.addToCartButton);
		p.addToCartButton.click();

	}

	@And("Click Cart Icon button")
	public void click_cart_icon_button2() {

		h.cartIconButton.click();
	}

	@Then("Verify User able to change the quantity of product in the Cart")
	public void verify_user_able_to_change_the_quantity_of_product_in_the_cart() {
wait(5);
		c.inputQuantity(c.quantityBox, BaseClass.getPropertyString("quantity"));
wait(5);
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		c.checkQuantityByPrice(c.unitPrice, c.subTotalPrice);

	}

//3. Scenario: Go shopping button


	@When("User should be able to see and click Go Shopping button")
	public void user_should_be_able_to_see_and_click_go_shopping_button() {

		// check if the cart is empty
		try {
			if (c.deleteButton.isDisplayed()) {
				c.deleteButton.click();
				c.confirmDeleteButton.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		waitForVisibility(c.cartEmptyMsg);
		String cartEmptyText = c.cartEmptyMsg.getText();
		Assert.assertTrue(cartEmptyText.contains(BaseClass.getPropertyString("emptyCartMsg")));
		c.clickGoShoppingButton();
	}
	


}// class
