Feature: search functionality

  Background: 
    Given Browser is open4
    And user is on website home page4

  @Smoke
  Scenario: Check the search for the product which is not available
    When user enters the product to be searched
    And clicks on search
    Then Message is displayed as no product found
