package mainPK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class MainSteps extends CommonMethods{

	
//------------------------------------Alip------------------------------------------------------------
//	Alip Scenario: ProductPage Test 1


	@When("User search for product in search bar input {string}")
	public void user_search_for_product_in_search_bar_input(String searchItem) {
		
		//searchItem = BaseClass.getPropertyString("searchItem2");   // if want to change searchItem
		CommonMethods.sendText(h.searchInput, searchItem);
	    CommonMethods.click(h.searchIcon);
	}

	@Then("User should be on ProductPage")
	public void user_should_be_on_product_page() {
		p.checkProductSortBy();
	}


	@Then("Click on index {int} of product")
	public void click_on_index_of_product(Integer index) {
		
		//index = BaseClass.getPropertyInteger("productIndex1");  // if want to change index value
		CommonMethods.clickValueFromListByIndex(p.productList, index);
		
	}


	@Then("Check for description and reviews")
	public void check_for_description_and_reviews() {
	    Assert.assertTrue(p.descriptionsInsideProduct.isDisplayed());
	    CommonMethods.jsClick(p.reviewsButtonInsideProduct);
	    Assert.assertTrue(p.reviewsInsideProduct.isDisplayed());
	}
	
	
	
	
	
	
//	Alip Scenario: ProductPage Test 2
	@Then("Click price button in sort by")
	public void click_price_button_in_sort_by() {
		//CommonMethods.waitForClickability(p.sortByButtonsList.get(0));
	    CommonMethods.clickValueFromListByText(p.sortByButtonsList, BaseClass.getPropertyString("sortByPriceText"));
	}
	@Then("Check if the product is sorted from low to high")
	public void check_if_the_product_is_sorted_from_low_to_high() {
		
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		for(int i = 0; i < p.productsPriceList.size()-1; i++) {
			
			double a = Double.parseDouble(p.productsPriceList.get(i).getText().substring(1));
			double b = Double.parseDouble(p.productsPriceList.get(i+1).getText().substring(1));
			
			Assert.assertTrue(a<=b);
		}
	}
	
	@Then("Check if the product is sorted from high to low")
	public void check_if_the_product_is_sorted_from_high_to_low() {
		for(int i =0; i < p.productsPriceList.size()-1; i++) {
			
			double a = Double.parseDouble(p.productsPriceList.get(i).getText().substring(1));
			double b = Double.parseDouble(p.productsPriceList.get(i+1).getText().substring(1));
			
			Assert.assertTrue(a>=b);
		}
	}


	
	
//	Alip Scenario: ProductPage Test 3
	
	@Then("Click and enter {string} and {string} price")
	public void click_and_enter_and_price(String minPrice, String maxPrice) {
		
		minPrice = BaseClass.getPropertyString("min");
		maxPrice = BaseClass.getPropertyString("max");
		
		CommonMethods.sendText(p.minBox, minPrice);
	    CommonMethods.sendText(p.maxBox, maxPrice);
	    
	    CommonMethods.waitForClickability(p.okButtonInMinMax);
	    p.okButtonInMinMax.click();
	    
	    CommonMethods.waitForVisibility(p.sortByButtonsList.get(0));
	}


	@Then("Check if the lowest price is higher than min")
	public void check_if_the_lowest_price_is_higher_than_min() {
		double a = Double.parseDouble(p.productsPriceList.get(0).getText().substring(1));	
		Assert.assertTrue(a>=100);
	}
	
	@Then("Check if the highest  price is lower than max")
	public void check_if_the_highest_price_is_lower_than_max() {
		double a = Double.parseDouble(p.productsPriceList.get(0).getText().substring(1));	
		Assert.assertTrue(a<=200);
	}

	//------------------------------------Armeena ------------------------------------------------------------
	// Armeena 1. Scenario: Yellow Banner tabs navigate
	@Then("User click on each tabs on yellow banner menu. User should navigate to each page after clicking")
	public void user_click_on_each_tabs_on_yellow_banner_menu() {

		
		ArrayList<String> yellowBanner = new ArrayList<>(Arrays.asList("flash-sale", "app-exclusive", "new-products"));

		for (int i = 0; i < h.yellowTabList.size(); i++) {
		
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

			h.yellowTabList.get(i).click();
			Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(yellowBanner.get(i)));

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
 
			wait(2);
			BaseClass.getDriver().navigate().back();
			wait(2);
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
	
//------------------------------------Maria ------------------------------------------------------------
	//Scenario 1  Verify search suggestion by keyword input
		@Then("Verify User should be able to see suggestion drop down that matching the in put keyword")
		public void verify_suggestion() {
			 
			h.searchInput.sendKeys(" "); // if not put this in, it will not detect suggestion dropdown
			wait(1);
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

//------------------------------------Pawitri ------------------------------------------------------------
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
			wait(3);
			waitVisibilityOfList(p.addToCartButtonList);
			clickSpecificElementInListByText(p.addToCartButtonList, "Add to Cart");

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
		
		
//------------------------------------Sumetta ------------------------------------------------------------
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

		
		
}//class
