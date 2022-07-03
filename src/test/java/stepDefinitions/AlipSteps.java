package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class AlipSteps extends CommonMethods{
	
	

//	Scenario: ProductPage Test 1


	@When("User search for product in search bar input {string}")
	public void user_search_for_product_in_search_bar_input(String searchItem) {
		
		//searchItem = BaseClass.getPropertyString("searchItem2");   // if want to change searchItem
		CommonMethods.sendText(h.searchInput, searchItem);
	    CommonMethods.click(h.searchIcon);
	}

	@Then("User should be on ProductPage")
	public void user_should_be_on_product_page() {
		p.checkProductPageURL();
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
	
	
	
	
	
	
//	Scenario: ProductPage Test 2
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


	
	
//	Scenario: ProductPage Test 3
	
	@Then("Click and enter {string} and {string} price")
	public void click_and_enter_and_price(String minPrice, String maxprice) {
		CommonMethods.sendText(p.minBox, BaseClass.getPropertyString("min"));
	    CommonMethods.sendText(p.maxBox, BaseClass.getPropertyString("max"));
	    
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




	



	
	

}
