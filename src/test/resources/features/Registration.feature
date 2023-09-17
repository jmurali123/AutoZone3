@Regression @smoke
Feature: User Registration
  As a new user
  I want to register to the automationzone
  So that I can access my account


  Scenario: Successful registration

    Given I am on the Automation Zone page
    And I am a new user
      | username    | email                 | password        |
      | Testuser107 | Testuser107@gmail.com | Password@123$#$ |

    And I log out from the application

