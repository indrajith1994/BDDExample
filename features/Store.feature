Feature: Online shopping

  Background:
    Given I navigate to the URL "https://www.demoblaze.com/index.html"

  Scenario: alert validation
    When I click on SignUp link
    And Give User information on page
    Then validate the success msg

  Scenario: Place product
    When select product and validate price and description
      | product          |
      | Nokia lumia 1520 |
      | Sony xperia z5   |
    Then fill the form and validate success msg

  Scenario: display broken links
    Then display broken links