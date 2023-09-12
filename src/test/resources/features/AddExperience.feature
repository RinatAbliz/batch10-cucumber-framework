@AddEducation
Feature: Add Experience

  #@api @AddExperienceUnhappy
  #Scenario Outline:
  #Given [API] User is logged in
  #| userName | mochen703@gmail.com |
  #| password | As5889590           |
  #When user is try to add new experience
  #| company     | <company>     |
  #| title       | <title>       |
  #| location    | <location>    |
  #| from        | <from>        |
  #| to          | <to>          |
  #| current     | <current>     |
  #| description | <description> |
  #Then user will recevied error massage
  #| errors | <error> |
  #
  #Examples:
  #| company  | title             | location  | from       | to | current | description          | error                                                        |
  #| BoraTech |                   | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Title is required                                            |
  #|          |                   | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Title is required ,Company is required                       |
  #|          |                   |           |            |    | true    | Wroking hard everday | Title is required ,Company is required,From date is required |
  #|          | Automation Tester | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Company is required                                          |
  #| BoraTech | Automation Tester | Annandale |            |    | true    | Wroking hard everday | From date is required                                        |
  Scenario: UI - Add Experience Happy Path
    Given user is on the BoraTech Dashboard page
      | email    | mochen703@gmail.com |
      | password | As5889590           |
    When user is click Add Experience
    And user will be navagit to Add Experience Page
    And user enter the Experience Information
      | company     | BoraTech                 |
      | title       | Software Engineer        |
      | location    | Annandale                |
      | from        | 08-16-2023               |
      | to          |                          |
      | current     | true                     |
      | description | This is a new experience |
    Then user should see a success alert that says [Experience Added]

  @UI
  Scenario Outline: Unhappy path
    Given user is on the BoraTech Dashboard page
      | email    | mochen703@gmail.com |
      | password | As5889590           |
    When user is click Add Experience
    And user will be navagit to Add Experience Page
    And user enter the Experience Information
      | company     | <company>     |
      | title       | <title>       |
      | location    | <location>    |
      | from        | <from>        |
      | to          | <to>          |
      | current     | <current>     |
      | description | <description> |
    Then user will see Alert
      | alerts | <alert> |

    Examples: 
      | company  | title             | location  | from       | to | current | description          | alert                                                        |
      | BoraTech |                   | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Title is required                                            |
      |          |                   | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Title is required ,Company is required                       |
      |          |                   |           |            |    | true    | Wroking hard everday | Title is required ,Company is required,From date is required |
      |          | Automation Tester | Annandale | 2018-02-12 |    | true    | Wroking hard everday | Company is required                                          |
      | BoraTech | Automation Tester | Annandale |            |    | true    | Wroking hard everday | From date is required                                        |
