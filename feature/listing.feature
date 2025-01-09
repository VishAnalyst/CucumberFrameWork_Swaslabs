Feature: Add to Cart Scenarios in Listing Page
  This feature file contains test scenarios to verify the Add to Cart functionality on the listing page.

  Scenario: Verify Add to Cart functionality for one item
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    And I navigate to the listing page
    And I click the Add to Cart button for one item
    And Remove should be displayed on the clicked button
    Then The cart count should reflect as one
    And I quit the browser

  Scenario: Verify Add to Cart functionality for all item adding to cart
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    And I navigate to the listing page
    When I click the Add to Cart button for all the item
    And Remove should be displayed on all the clicked button
    Then The cart count should reflect as 6
    And I quit the browser

