Feature: Create Account

  Background:
    Given I navigate to the URL "https://petstore.octoperf.com/actions/Catalog.action" and click on SignIn link

  Scenario:Create account and login
    When I click on Signin link and click on register now
    And I should navigate to User information page and enter all details
      | FirstName | LastName | uid  | Email             | Password | Address | City      | State | PostCode | PhoneNumber | Country | Mylist | Mybanner |
#      | Testnew   | lastname | uwon | testonq@gmail.com | Pass123  | Test123 | New Jersy | Ka    | 567541   | 123456789   | India   | yes    | yes      |
      | Testnew   | lastname | testpet | testonq@gmail.com | Pass123  | Test123 | New Jersy | Ka    | 567541   | 123456789   | India   | yes    | yes      |
    Then Login with userid

  Scenario: Place order
    When Sign in with valid userid
    And Add product and update cart qty and checkout
      | Pets  | product  | Qty |Itemid|
      | Birds | AV-CB-01 | 2   |EST-18|
    Then Validate the order number in the submitted page


  Scenario: Create new account with multiple sets of data
    When Sign in with valid userid
    And Add product and update cart qty and checkout
      | Pets  | product  | Qty |Itemid|
      | Birds | AV-CB-01 | 2   |EST-18|
      | Fish  | FI-FW-01 | 3   |EST-4 |
    Then Validate the order number in the submitted page

