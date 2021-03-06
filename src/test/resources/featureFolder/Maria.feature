@Maria
Feature: Search functionality

  Background: 
  Given User is navigated to Home page

  Scenario: Verify search suggestion by keyword input
    Given User search for product in search bar input "car "
    Then Verify User should be able to see suggestion drop down that matching the in put keyword

  Scenario: Verify All button drop down list functionality
    Given User clicks All button on searchBar
    Then User clicks on each Tab in Options list. Verify User should be able to navigate to correspondant tab page which is clicked

  Scenario: Verify search functionality by item name
    Given User search for product in search bar input "wheel"
    Then User should be navigated to searched item page
