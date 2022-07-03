@Pawitri
Feature: Cart Functionality 

Scenario: Cart button
Given User is navigated to Home page
Then Click each tab on yellow banner. User should navigate to the Cart page after clicking the Cart icon button

Scenario: Changing quantity of product in the Cart
Given Click the category tab
When Click the chosen product and click Add to cart button
And Click Cart Icon button 
Then Verify User able to change the quantity of product in the Cart


Scenario: Go shopping button
Given Click Cart Icon button
When User should be able to see and click Go Shopping button
Then User is navigated to Home page