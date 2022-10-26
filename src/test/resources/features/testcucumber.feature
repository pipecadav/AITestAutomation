Feature: PoC testing


  Scenario: Validate I can properly search for a product in Amazon.com
    Given I go into 'amazon' marketplace
    When I search for 'Alexa'
    Then I should see a page with results for the matching criteria
    When I navigate to page number 2
    And I select item 3 from the list
    Then I should be redirected to the product details
    And I should be able to add the product to the cart