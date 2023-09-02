Feature: Amazon

  @UI @Amazon
  Scenario: 
    Given user is on the amazon homepage
    When user search for - "shampoo" and submit
    Then user should see the Items related - "shampoo"
