@test
Feature: HomePage Functionality

  Scenario Outline: Testing Homepage

    Given I enter the application "<URL>" in the browser
    When I navigated to homepage
    And I search for the name with user logged in
    Then I validate the user navigated to the screen
    
    Examples:
    |URL|
    |http://demo.guru99.com/V4/|
    