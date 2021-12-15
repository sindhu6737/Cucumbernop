Feature: feature to test login functionality

  Background: 
    Given Browser is open2
    And user is on website home page2
    And user clicks on Log in option

  @Smoke
  Scenario: Check login is successful with valid credentials
    When user enters the username and password
    And clicks on Log in button
    Then User should be on home page

  @Smoke
  Scenario: Check login  with invalid username
    When user enters the invalid username and password
    And clicks on Log in button
    Then User should get an error message for invalid username

  @Smoke
  Scenario: Check login with invalid password
    When user enters the valid username and invalid password
    And clicks on Log in button
    Then User should get an error message for invalid password

  @Smoke
  Scenario: Check login with empty fields
    When user directly clicks on Login
    Then user should get an error message for empty fields

  @Smoke
  Scenario: Check login with unregistered user
    When user enters unregistered user details
    And clicks on Log in button
    Then User should get an error message for unregistered user
