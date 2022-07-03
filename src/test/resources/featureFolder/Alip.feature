@Alip
Feature: ProductPage Functionality

 Background: 
  Given User is navigated to Home page

  Scenario: ProductPage Test 1
 		Given User is navigated to Home page
		When User search for product in search bar input "Iphone"
		Then User should be on ProductPage 
		Then Click on index 0 of product
		Then Check for description and reviews
		
		
	Scenario:  ProductPage Test 2
    Given User is navigated to Home page
		When User search for product in search bar input "Ipad"
		Then User should be on ProductPage
		Then Click price button in sort by
		Then Check if the product is sorted from low to high
		Then Click price button in sort by
		Then Check if the product is sorted from high to low
		

	Scenario: ProductPage Test 3
		Given User is navigated to Home page
		When User search for product in search bar input "macbook"
		Then User should be on ProductPage
		Then Click and enter "min" and "max" price
		Then Click price button in sort by
		Then Check if the lowest price is higher than min 
		Then Click price button in sort by
		Then Check if the highest  price is lower than max
		