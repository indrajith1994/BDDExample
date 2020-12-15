Feature: The coop link

  Background:
    Given The page URL is "http://coop.apps.symfonycasts.com"
  Scenario: Get request - directly passing token
#    Given The barn unlock url is "/api/1568/barn-unlock"
    Given The barn unlock url is "/api/1568/barn-unlock"
    When Perform post operation
      | Key          | Value                                    |
#      | access_token | 6799f5c521c7f315f5500462f86010cf5c4fc602 |
      | Authorization | Bearer fc09431c026837a319e5a94024dfd2f947005e90 |
      | Content-Type | application/json                         |
    Then Validate the response of post

  Scenario: Get the Access token
    Given make the token call "/token"
    When perform post token call
    Then validate call

  Scenario: chickens-feed call
    Given make the token call "/api/1568/barn-unlock"
    When perform chickens-feed call
    Then validate call