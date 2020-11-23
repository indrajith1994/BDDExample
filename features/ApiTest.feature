Feature: API Test

  Scenario: Get Request

    Given I have an endpoint url "http://dummy.restapiexample.com/api/v1/employees"
    When I hit the get request
    Then I should validate the response code and response body after Get request

  Scenario: Post Request 1
  #getting 429 status code -  Too Many Requests
    Given I have an endpoint url "http://dummy.restapiexample.com/api/v1/create"
    When I hit the post request
    Then I should validate the response code and success message after Post request

  Scenario: Post Request 2

    Given I have an endpoint url "https://reqres.in/api/users"
    When I hit the post request
    Then I should validate the response code and success message after Post request

  Scenario: Put Request
  #getting 429 status code -  Too Many Requests
    Given I have an endpoint url "http://dummy.restapiexample.com/api/v1/update/05"
    When I hit the put request
    Then I should validate the response code and success message after Put request


  Scenario: Get Request validate print empname and salary

    Given I have an endpoint url "http://dummy.restapiexample.com/api/v1/employees"
    When I hit the get request
    Then I should validate the response code and print all the employee names and salary from the data set
    Then I should validate all the headers from the response


  Scenario Outline: Get Request Parameter validate email and lastname

    Given I have an endpoint url "https://reqres.in/api/users"
    When I hit the get request "<page>"
    Then I should validate the response code and print all the email ids from the data set
    Then I should validate last name associated with email id from data set
    Then I should validate all the headers from the response

    Examples:
      | page |
      | 2    |


  #    https://petstore.swagger.io - Access to Petstore orders

  Scenario: Post Request - new order Step - 1

    Given I have an endpoint url "https://petstore.swagger.io/v2/store/order"
    When I hit the post request with header
    Then I should validate the response code and success message after Post request
    Then I should validate all the headers from the response
    Then Body has below given json details
      | Key      | Value |
      | id       | 42    |
      | petId    | 3234  |
      | quantity | 1     |

  Scenario: Get Request - order history - Step 2 + Step 4

    Given I have an endpoint url "https://petstore.swagger.io/v2/store/order/42"
    When I hit the get request
    Then I should validate the response code and response body after Get request

  Scenario: Delete Request - delete Post request data - Step 3

    Given I have an endpoint url "https://petstore.swagger.io/v2/store/order/42"
    When I hit the delete request
    Then I should validate the response code after Delete request


  #    https://petstore.swagger.io - Access to Petstore orders

  Scenario: Post - Create with array
    Given I have an endpoint url "https://petstore.swagger.io/v2/user/createWithArray"
    When I hit the post request with array format
    Then I should validate the response code and success message after Post request
    Then I should validate all the headers from the response
    Then Body has below given json details
      | Key     | Value   |
      | code    | 200     |
      | type    | unknown |
      | message | ok      |

  Scenario: Get Request - Check Array format data is available
    Given I have an endpoint url "https://petstore.swagger.io/v2/user/Array"
    When I hit the get request
    Then I should validate the response code and response body has below given json details
      | Key        | Value              |
      | id         | 1234               |
      | username   | Array              |
      | firstName  | Userone            |
      | lastName   | Lastname           |
      | email      | testemail@test.com |
      | password   | qwerty             |
      | phone      | 1234567            |
      | userStatus | 0                  |


  Scenario: Post - Create with list
    Given I have an endpoint url "https://petstore.swagger.io/v2/user/createWithList"
    When I hit the post request with List format
    Then I should validate the response code and success message after Post request
    Then I should validate all the headers from the response
    Then Body has below given json details
      | Key     | Value   |
      | code    | 200     |
      | type    | unknown |
      | message | ok      |

  Scenario: Get Request - Check List format data is available
    Given I have an endpoint url "https://petstore.swagger.io/v2/user/List"
    When I hit the get request
    Then I should validate the response code and response body has below given json details
      | Key        | Value         |
      | id         | 2345          |
      | username   | List          |
      | firstName  | Listname      |
      | lastName   | Lastname      |
      | email      | test@test.com |
      | password   | asdfgh        |
      | phone      | 12345         |
      | userStatus | 0             |


  Scenario: Put Request - Update the List user details

    Given I have an endpoint url "https://petstore.swagger.io/v2/user/List"
    When I hit the put request update user
    Then I should validate the response code and response body has below given json details
      | Key     | Value   |
      | code    | 200     |
      | type    | unknown |
      | message | 2345    |

  Scenario: Delete Request - Delete the ListChanges profile

    Given I have an endpoint url "https://petstore.swagger.io/v2/user/ListChanges"
    When I hit the delete request
    Then I should validate the response code and response body has below given json details
      | Key     | Value       |
      | code    | 200         |
      | type    | unknown     |
      | message | ListChanges |


# Basic Authentication
  Scenario: Testing basic auth

    Given I have an endpoint url "https://postman-echo.com/basic-auth"
    When I hit the get request basic auth
    Then I should validate the response code and response body after Get request

    #  Digest Authentication
  Scenario: Testing Digest auth

    Given I have an endpoint url "https://postman-echo.com/digest-auth"
    When I hit the get request Digest Auth
    Then I should validate the response code and response body after Get request
#   Hawk Auth
#  Not having this auth
#  Scenario: Testing Digest auth
#
#    Given I have an endpoint url "https://postman-echo.com/digest-auth"
#    When I hit the get request Hawk Auth
#    Then I should validate the response code and response body after Get request


# https://gorest.co.in/ url
#  Authentication with header
  Scenario: Header as direct arg get

    Given I have an endpoint url "https://gorest.co.in/public-api/users"
    When I hit the get request auth
    Then I should validate the response code and response body after Get request

  Scenario: Header as direct arg post

    Given I have an endpoint url "https://gorest.co.in/public-api/users"
    When I hit the post request auth
    Then I should validate the response code and success message after Post request

#    header parameter
  Scenario: Header as datatable arg get

    Given I have an endpoint url "https://gorest.co.in/public-api/users"
    When I hit the get request auth param
      | Key           | Value                                                                   |
      | Authorization | Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e |
      | Content-Type  | application/json                                                        |
    Then I should validate the response code and response body after Get request

  Scenario: Header as datatable arg post

    Given I have an endpoint url "https://gorest.co.in/public-api/users"
    When I hit the post request auth param
      | Key           | Value                                                                   |
      | Authorization | Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e |
      | Content-Type  | application/json                                                        |
    Then I should validate the response code and success message after Post request
    And Validate with get request



  Scenario: Testing sceanrio 1

    Given I have an endpoint url "https://gorest.co.in/public-api/users"
    When I have 1 book here
    When I have note here
    Then I should validate the response code and success message after Post request

  Scenario: Testing sceanrio 2

    Given I have an endpoint url "https://gorest.co.in/public-api/users"
    When I have 4 books here
    When I have notes here
    Then I should validate the response code and success message after Post request

#    https://reqres.in/
#  Step wise scenario
    Scenario: Basic of RestAPI
      Given Hitting endpoint url "https://reqres.in"
      When Making post request
      Then Validate post Response

#      New Scenario

