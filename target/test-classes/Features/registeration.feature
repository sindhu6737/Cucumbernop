Feature: User Registeration

  Background: 
    Given Browser is open1
    And user is on website home page1
    And user clicks on Register option

  @Smoke
  Scenario: check the register page
    When user clicks on Register option
    Then registration form is displayed

  @Smoke
  Scenario: Check register with valid input fields
    When user enters the following details
      | firstname | lastname | Date | month | year | email         | company name | password | confirm password |
      | sindhu    | Naik     |   23 | June  | 2000 | abc06@gmail.com | IVL          |   123456 |           123456 |
    Then user clicks on register button

  @Smoke
  Scenario: check register for empty fields
    When user directly clicks on register button
    Then user should get error message for empty fields

  @Smoke
  Scenario: check register for invalid email
    When user enters the following details with invalid email
      | Firstname | Lastname | date | Month | Year | Email | Company name | Password | Confirm password |
      | sindhu    | naik     |   23 | June  | 2000 | sin   | IVL          |   123456 |           123456 |
    And clicks on the register option
    Then user should get error message for invalid email

  @Smoke
  Scenario: check register with different values for password and confirm password
    When user enters the following details with different passwords
      | fname  | lname | dates | Months | Years | Emailid          | Company | Pass   | Confirm pass |
      | sindhu | naik  |    23 | June   |  2000 | anusha@gmail.com | IVL     | 123456 | sindhu1234   |
    And clicks on the register option
    Then user gets error message for different passwords

  @Smoke
  Scenario: check register with invalid password
    When user enters the following details with invalid password
      | fname  | lname | dates | Months | Years | Emailid         | Company | Pass | Confirm pass |
      | sindhu | naik  |    23 | June   |  2000 | sindhu@gmail.com| IVL     |    1234567 |           1234567|
    And clicks on the register option
    Then user gets error message for invalid password

  @Smoke
  Scenario: check register for duplicate user
    When user enters details that already exist
    And clicks on the register option
    Then user gets error
