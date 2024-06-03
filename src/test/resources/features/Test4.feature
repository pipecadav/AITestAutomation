Feature: Test4

  @Test-4
  Scenario: Validate I can see a page with the deals of the day in Amazon.com
    Given I go into 'amazon' marketplace
    When I click on Today's deals
    Then I should see a page with the deals of the day


