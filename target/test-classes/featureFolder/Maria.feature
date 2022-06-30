Feature: Search functionality

  Background: User is on Home Page

  Scenario: Verify search functionality by keyword input
    Given User is on Home Page and inputs "<searchItem>"
    Then Verify User should be able to see search list of searchItem

 #@SmokeTest 
  Scenario: Verify All Button drop down list functionality
    And User clicks All button on searchBar
    And User clicks on each Tab in Options list
    Then Verify User should be able to navigate to correspondant tab page which is clicked

  Scenario: Verify search functionality by item name
    And User inputs items name in search bar
    And User clicks search icon11
    Then User should be navigated to searched item page
