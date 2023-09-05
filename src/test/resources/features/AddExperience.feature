Feature: Add Experience

  @api @AddExperienceUnhappy
  Scenario Outline: 
    Given [API] User is logged in
      | userName | mochen703@gmail.com |
      | password | As5889590           |
    When user is try to add new experience
      | company     | <company>     |
      | title       | <title>       |
      | location    | <location>    |
      | from        | <from>        |
      | to          | <to>          |
      | current     | <current>     |
      | description | <description> |
    Then user will recevied error massage
      | errors | <error> |

    Examples: 
      | company  | title             | location  | from       | to | current | description          | error                                                        |
      | BoraTech |                   | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Title is required                                            |
      |          |                   | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Title is required ,Company is required                       |
      |          |                   |           |            |    | true    | Wroking hard everday | Title is required ,Company is required,From date is required |
      |          | Automation Tester | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Company is required                                          |
      | BoraTech | Automation Tester | Annandale |            |    | true    | Wroking hard everday | From date is required                                        |
