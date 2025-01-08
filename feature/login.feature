Feature: All login Scenarios
  This feature file contains test scenarios to verify the login functionality.

  Scenario: To check the login scenario with valid credentials.
    Given I am on the login page.
    When I enter correct username and password.
    And I click the login button.
    Then I should be redirected to the listing page.
    And I need to quit the browser.

  Scenario: To check the login scenario with invalid credentials.
    Given I am on the login page.
    When I enter incorrect username and password.
    And I click the login button.
    Then I should not be redirected to the listing page.
    And I need to quit the browser.