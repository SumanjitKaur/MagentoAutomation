Feature: Create and login to an account on Magento

  Scenario: User creates an account and logs in
    Given I am on the homepage
    When I navigate to the Create Account page
    And I fill in the account details and submit
    Then I should see the account creation success message
    When I log out
    And I log in with the newly created account
    Then I should see the welcome message