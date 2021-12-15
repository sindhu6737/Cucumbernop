Feature: Check Shopping cart functionality

  Background: 
    Given Browser is open3
    And user is on website home page3

  @Smoke
  Scenario: check the URL
    When user clicks on shopping cart
    Then cart should be displayed

  @Smoke
  Scenario: check shopping cart with zero products
    When user clicks on shopping cart
    Then message should be displayed for empty cart

  @Smoke
  Scenario: check shopping cart with products added
    When user adds product to the cart
    And clicks on shopping cart
    Then Products should be displayed with price

  @Smoke
  Scenario: check delete item from cart
    When user clicks on remove option
    Then products should be removed
