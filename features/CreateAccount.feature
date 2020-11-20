Feature: Create Account

  Background:
    Given I navigate to the URL "http://automationpractice.com/" and click on SignIn link

  Scenario: Create new account
    When I enter email address "testonq@test.com"and click on Create an account button
    And I fill up the new account form with the following data and click on Register button
      | FirstName | LastName | Gender | Email             | Password | Address | City      | State  | PostCode | PhoneNumber | AddressAlias |
      | Test      | LastNm   | Mr     | testonq@gmail.com | Pass123  | Test123 | New Jersy | Kansas | 56754    | 123456789   | Testing      |
    Then The user should be able to create an account


#  Scenario: Create new account with multiple sets of data
#
#    And I fill up the new account form with the multiple sets of data and click on Register button
#      | FirstName | LastName | Email           | Password | Address | City      | PhoneNumber | AddressAlias |
#      | Test      | Test1    | test@gmail.com  | Pass123  | Test123 | New Jersy | 123456789   | Testing      |
#      | Test      | Test2    | test1@gmail.com | Pass1234 | Test123 | New Jersy | 123456789   | Testing      |
#    Then The user should be able to create an account
#
  Scenario: Place an Order
    When I move cursor to Dresses and click on Casual dresses
    And I add the items to the cart and navigate til checkout page
    And I increase the quantity by clicking + icon from Qty section and click on checkout button
    Then I Validate that the User is navigated to Login page