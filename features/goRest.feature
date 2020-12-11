Feature: goRest API Test
  Scenario: Get Method List all user 
    Given Hit endpoint url "https://gorest.co.in"
    When Hitting the Get request auth param
      | Key           | Value                                                                   |
      | Authorization | Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e |
      | Content-Type  | application/json                                                        |
    Then Validate Get response

  Scenario: Post Method create new user
    Given Hit endpoint url "https://gorest.co.in/"
    When Hitting the Post request auth param
      | Key           | Value                                                                   |
      | Authorization | Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e |
      | Content-Type  | application/json                                                        |
    Then Validate Post response

  Scenario: Get Method retrieve created user
    Given Hit endpoint url "https://gorest.co.in"
    When Hitting the Get request auth param retrieve
      | Key           | Value                                                                   |
      | Authorization | Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e |
      | Content-Type  | application/json                                                        |
    Then Validate Get response

  Scenario: PUT Method update created user
    Given Hit endpoint url "https://gorest.co.in"
    When Hitting the Put request auth param
      | Key           | Value                                                                   |
      | Authorization | Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e |
      | Content-Type  | application/json                                                        |
    Then Validate Put response

  Scenario: Delete Method delete created user
    Given Hit endpoint url "https://gorest.co.in"
    When Hitting the Delete request auth param
      | Key           | Value                                                                   |
      | Authorization | Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e |
      | Content-Type  | application/json                                                        |
    Then Validate Delete response
