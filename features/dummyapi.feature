Feature: API Test

  Scenario: Task 1 - post call

#    Given I have an endpoint url "http://dummy.restapiexample.com/api/v1/employees"
    Given Reach endpoint url "http://dummy.restapiexample.com"
    When Hit the post request
      | Key      | Value |
      | Name       | 42    |
      | Emp-id    | 3234  |
      | Company | 1     |
    Then I should validate the response code and response body after Post request