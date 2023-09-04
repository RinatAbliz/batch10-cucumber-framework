Feature: Add Experience

  @api
  Scenario: 
    Given [API] User is logged in
      | userName | mochen703@gmail.com |
      | password | As5889590           |
    Then [API] User should be able to add new experience
