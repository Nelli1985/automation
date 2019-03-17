@selenium
Feature: Login test with incorrect and correct credentials

  Scenario: User should not be logged into the application with incorrect credentials
    Given I have opened the application main page url: "http://automationpractice.com/index.php"
    And I have opened the login page
    When I will enter "user1" as username and "qwerty" as password and try to login
    Then I will be promted error message
    And I'm not logged into the application

  Scenario: User should be logged into the application with correct credentials
    Given I have opened the application main page url: "http://automationpractice.com/index.php"
    And I have opened the login page
    When I will enter "user1@login.ee" as username and "qwertyqwerty" as password and try to login
    Then I'm logged into the application
    And I log off successfully

  Scenario Outline: User should not be logged into the application with list of incorrect credentials
    Given I have opened the application main page url: "http://automationpractice.com/index.php"
    And I have opened the login page
    When I will enter the Email <email> and Password <password>
    Then I will be promted error message
    And I'm not logged into the application
    Examples:
      | email          | password |
      |                |          |
      | user1          |          |
      |                | qwerty   |
      | user2          | qwerty   |
      | user3          | *        |
      | user4@login.ee | qwerty   |

