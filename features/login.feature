Feature: Login Functionality

  Scenario Outline: ABC
    Given I enter the URL in the browser
    When I enter "<username>" and "<password>" and login button
    And I validate the login credentials
    Then I validate the application

    Examples: 
      | username | password  |
      | abc      | password1 |
      | abc1     | password2 |
