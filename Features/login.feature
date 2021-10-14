Feature:
  Scenario: Successful login for correct username and password
    Given I am on login page of billing
    When I enter valid username and password
    And I click on login button
    Then I should be redirected to home page