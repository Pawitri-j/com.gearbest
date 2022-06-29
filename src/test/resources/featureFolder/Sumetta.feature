Feature: HomePage9


Scenario: Changing Language
Given User on home page9
When Click on Language button
Then Verify if user can change the language

Scenario: Changing currency
Given User on home page9
When Click on Ship To(currency) button
And Select the currency 
Then Use should be able to change the currency

Scenario: Category tabs on the Home page
Given User on home page9
Then Click on  each Tab under Category and each Tab should navigate to respective page
