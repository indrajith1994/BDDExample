@test
Feature: Shopping cart demo

  Background:
    Given Navigate to shopping url

  @loginSauce
  Scenario: Login
#    When Get Username from homepage
#    When Get Password from homepage
    When Get Username and Password from homepage and enter
    When Click Login button
    Then Validate user is in home page
    And Close driver

  @Add_product
  Scenario Outline: Adding product
    When Get Username and Password from homepage and enter
    When Click Login button
    When Search for "<product>" product
    When Click on Cart icon
    Then Verify product details
    And Checkout
    And Close driver
    Examples:
      | product                  |
      | Sauce Labs Fleece Jacket |

  @Cartpage
  Scenario Outline: Checkout page validation
    When Get Username and Password from homepage and enter
    When Click Login button
    When Search for "<product>" product
    When Click on Cart icon
    And Checkout
    And Enter checkout information
#    And Continue Checkout
    And Verify product details Checkout
    And Finish
    Then Verify success message
    And Close driver
    Examples:
      | product                  |
      | Sauce Labs Fleece Jacket |


  @Continue_shopping
  Scenario Outline: Continue shopping
    When Get Username and Password from homepage and enter
    When Click Login button
    When Search for "<product>" product
    When Click on Cart icon
    Then Verify product details
    And Continue shopping
    And Close driver
    Examples:
      | product                  |
      | Sauce Labs Fleece Jacket |