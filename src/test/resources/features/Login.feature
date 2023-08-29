Feature: Login

  Scenario: Happy Path
    Given user is on the boratech homepage
    When user navigates to the Login page
    And user enter the username - "mochen703@gmail.com" and password - "As5889590" and submit
    Then User should be on the Dashboard page
