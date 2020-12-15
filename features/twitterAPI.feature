Feature: Twitter api function

  Scenario: Tweet function
    Given Opening twitter page "https://api.twitter.com/1.1/statuses/update.json"
    When Making tweet post call
    Then Validate the response of tweet