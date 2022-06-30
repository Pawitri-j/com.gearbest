Feature: ProductPage Functionality

  Scenario: ProductPage Test 1
 		Given User on home page1
		When User search for product in search bar
		Then User should be on ProductPage
		Then Click on the first product
		Then Check for description and reviews
		
	Scenario:  ProductPage Test 2
    Given User on home page1
		When User search for product in search bar
		Then User should be on ProductPage
		Then Click price button in sort by
		Then Check if the product is sorted from low to high
		Then Click price button in sort by
		Then Check if the product is sorted from high to low

	Scenario: ProductPage Test 3
		Given User on home page1
		When User search for product in search bar
		Then User should be on ProductPage
		Then Click and enter min and max price
		Then Click price button in sort by
		Then Check if the lowest price is higher than min 
		Then Click price button in sort by
		Then Check if the highest  price is lower than max