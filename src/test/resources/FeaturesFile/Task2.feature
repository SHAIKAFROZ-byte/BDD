Feature: Testing OrangeHrm website

  Background:
    Given Opening the login portal
    When user should enter my valid username and password

  Scenario: Sign in with valid credentials to Website
    Then user should login and verify the title

  Scenario: Create a new Employee record
    And user clicks on PIM Section
    And user creates an employee record
    Then user checks for created employee record

  Scenario:  Sign out from the Website
    And user should profile icon
    Then user should logout

