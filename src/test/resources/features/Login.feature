@endtoend @Regression
Feature: Login to the account
  Scenario Outline:Login with user creds
    Given I am on the Automation Zone page
    And I am registered user with username "<username>" and password "<password>"
    Then the user "<username>" logins successfully
    Examples:
      | username | password        |
      | jmurali  | Password@123$$$ |