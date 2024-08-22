Feature:Login
  Scenario Outline: As a user i want to login and verify that i am logged in successfully
    Given I am on Login page
    And I enter the username <email>
    And I enter password <pass>
    When I click login button
    Then The home page is displayed

    Given I on the Home page
    And I select the Computers tab
    And I select desktops to purchase
    When I click on item to add to cart
    Then Cart Page is opened
    Examples:
      | email     | pass         |
      | mmoreroa@inspired.com | Makgomo09@ |


