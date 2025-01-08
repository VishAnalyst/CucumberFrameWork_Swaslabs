Feature: All login Scenarios
  Scenario: To check the login scenario with the valid credentials.
    Given I am on the login page.
    When I enter correct username and password.
    And I click the login button
    Then I should be redirected to the listing page.