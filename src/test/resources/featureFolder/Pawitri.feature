Feature: Cart Functionality 



Scenario: Cart button1
Given User on home page1
Then Click each tab  on yellow banner. User should navigate to the Cart page after clicking the Cart icon button1

Scenario: Changing quantity of product in the Cart2
Given Click Tab on Home page to product page2
When Click the chosen product and click Add to cart button2
And Click Cart Icon button1 
Then Verify User able to change the quantity of product in the Cart2 


Scenario: Go shopping button3
Given Click Cart icon button3
When User should be able to see and click Go Shopping button3 
Then the cart is empty which navigates to the homepage3