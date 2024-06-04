Feature: Test2

  @Test-2
  Scenario: Validate I see the Side Menu in the main page of Amazon.com
    Given I go into 'amazon' marketplace
    When I click on the side menu called All
    Then I should see a side menu with a hello message at the top of the menu