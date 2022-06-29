package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class PawitriSteps extends CommonMethods {

	// Scenario: Cart button1

	@Given("User on home page1")
	public void click_each_tab_on_home_page1() {

		h.checkHomePageURL();

	}

	@Then("Click each tab  on yellow banner. User should navigate to the Cart page after clicking the Cart icon button1")
	public void user_should_navigate_to_the_cart_page_after_clicking_the_cart_icon_button1() {

		waitVisibilityOfList(h.yellowTabList);
		h.clickCartButtonFromEachPageAndVerifyIfInCart();

	}

// Scenario: Changing quantity of product in the Cart2

	@Given("Click the category tab on Home page to product page2")
	public void click_tab_on_home_page_to_product_page2() {

		h.clickOnTheCategoryTab();
	}

	@When("Click the chosen product and click Add to cart button2")
	public void click_the_chosen_product_and_click_add_to_cart_button2() {

		waitVisibilityOfList(p.productList);
		clickValueFromListByIndex(p.productList, BaseClass.getPropertyInteger("index1"));
		
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		waitForClickability(p.addToCartButton);
		p.addToCartButton.click();
	}

	@And("Click Cart Icon button2")
	public void click_cart_icon_button2() {

		h.cartIconButton.click();
	}

	@Then("Verify User able to change the quantity of product in the Cart2")
	public void verify_user_able_to_change_the_quantity_of_product_in_the_cart2() {

		c.inputQuantity();

		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		c.checkQuantityByPrice();

	}

//Scenario: Go shopping button3

	@Given("Click Cart icon button3")
	public void click_cart_icon_button3() {
		
		h.cartIconButton.click();
	}

	@When("User should be able to see and click Go Shopping button3")
	public void user_should_be_able_to_see_and_click_go_shopping_button3() {

		c.checkIfCartisEmpty();
		c.clickGoShoppingButton();
	}

	@Then("Go Shopping button navigates to the homepage3")
	public void Go_Shopping_button_navigates_to_the_homepage3() {

		h.checkHomePageURL();
	}

}// class
