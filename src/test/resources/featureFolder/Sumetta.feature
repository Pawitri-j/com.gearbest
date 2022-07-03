@Sumetta
Feature: HomePage9

Background:
Given User is navigated to Home page

Scenario: Changing Language
When Click on Language button
Then Verify if user can change the language

Scenario: Changing currency
When Click on Ship To(currency) button
And Select the currency 
Then Use should be able to change the currency

Scenario: Category tabs on the Home page
Then Click on  each Tab under Category and each Tab should navigate to respective page
