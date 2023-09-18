Feature: Niki

  @Nike_Search
  Scenario: Happy path
    Given User is on the Nike homepage
    When User is searching for - "Air Jordan"
    Then User should see the products related to - "Air Jordan"
