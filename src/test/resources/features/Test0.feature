Feature: Test0

  @Test-0
  Scenario: Validate I can go to the cart from the main page of Amazon.com
    Given I go into 'amazon' marketplace
    When I click on the cart
    Then I should the cart page with an empty cart message


