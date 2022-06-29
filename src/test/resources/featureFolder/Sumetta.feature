Feature: HomePage9


Scenario: View more button
Given User on home page9
When Click View more button9
Then User should be able to see more products after clicking View more button9

Scenario: Changing currency
Given User on home page9
When Click on Ship To(currency) button10
And Select the currency 
Then Use should be able to change the currency10

Scenario: Category tabs on the Home page
Given User on home page9
Then Click on  each Tab under Category and each Tab should navigate to respective page11
