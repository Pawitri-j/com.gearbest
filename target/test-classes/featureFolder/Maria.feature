Feature: Search functionality

  Scenario: Verify search functionality by keyword input
    Given User is on Home Page and inputs "<searchItem>"
    Then Verify User should be able to see search list of searchItem
@SmokeTest
  Scenario: Verify All Button drop down list functionality
    Given User is on Home Page
    And User clicks All button on searchBar
    And User clicks on each Tab in Options list
    Then Verify User should be able to navigate to correspondant tab page
