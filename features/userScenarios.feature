Feature: User Scenarios

  Scenario: I should be able to create a new user
    Given the usersx endpoint exists
    When I send a valid create user payload
    Then response status code should be 201
    And create user response should be valid