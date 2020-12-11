Feature: The coop link

  Background:
    Given The page URL is "http://coop.apps.symfonycasts.com"

  Scenario: Get request
#    Given The barn unlock url is "/api/1568/barn-unlock"
    Given The barn unlock url is "/api/1568/barn-unlock"
    When Perform post operation
      | Key          | Value                                    |
#      | access_token | 6799f5c521c7f315f5500462f86010cf5c4fc602 |
      | Authorization | Bearer 6799f5c521c7f315f5500462f86010cf5c4fc602 |
      | Content-Type | application/json                         |
    Then Validate the response of post