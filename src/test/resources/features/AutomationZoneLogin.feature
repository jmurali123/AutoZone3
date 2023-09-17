@Practice
Feature: User Authentication
  As a user
  I want to be able to authenticate myself
  So that I can access my account

  Scenario: Successful Login
    Given a registered user with the user id "jmurali" and password "Muralij@2023$08"
    When the user enters the credentials and click on the login
    Then the system should authenticate the user

  Scenario Outline: Login with different creds
    Given I am registered user with username "<username>" with password "<password>"
    Then the user logins successfully
    Examples:
      | username  | password |
      | testuser1 | passoword1 |
      | testuser2 | password2  |


  Scenario: Test with datatable
    Given the user is on the landing page
      | Keerthi | Keerthi@123 |
      | Veera   | Veera@123   |


  Scenario: DataTableTestas Map
    Given the user entered the creds
      | username | password    |
      | Keethi   | Keerthi@123 |
      | Veera    | Veera@123   |



  Scenario: ReadDataFromJson
    Given the user entered the JSON testdata
      """
    {
    "users": [
    {
    "name": "john",
    "age": 30
    },
    {
    "name": "Peter",
    "age": 25,
    "department":[
    {
    "dep1":"Engineering"
    },{
    "dep2":"Electrical"
    }
    ]
    }
    ]
    }
    """

