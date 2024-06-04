Feature: Test3

  @Test-3
  Scenario: Validate I can properly search for a product in Amazon.com
    Given I go into 'amazon' marketplace
    When I search for 'Nintendo'
    Then I should see a page with results for the matching criteria