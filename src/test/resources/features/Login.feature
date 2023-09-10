@Login
Feature: Login

  @UI
  Scenario: Happy Path
    Given user is on the boratech homepage
    When user navigates to the Login page
    And user enter the username - "mochen703@gmail.com" and password - "As5889590" and submit
    Then User should be on the Dashboard page

  @UI
  Scenario Outline: Login Unhappy Path
    Given user is on the boratech homepage
    When user navigates to the Login page
    And user enter the email and password and click on submit
      | email    | <email>    |
      | password | <password> |
    Then User will recived errorAlert
      | errors | <error> |

    Examples: 
      | email               | password    | error               |
      | mochen703@gmail.com | As5889590.. | Invalid credentials |
      | mochen@gmail.com    | As5889590   | Invalid credentials |
#
  #@API
  #Scenario: APILogin - Happy Path
    #Given [API] User is logged in
      #| userName | mochen703@gmail.com |
      #| password | As5889590           |
#
  #@API @LoginUnhappy
  #Scenario Outline: API Login Unhappy Path
    #Given [API] User is try to loggin
      #| userName | <userName> |
      #| password | <password> |
    #Then [API] user is recevid loggin error
      #| error | <error> |
#
    #Examples: 
      #| userName             | password    | error                |
      #| mochen7013@gmail.com | As5889590   | Invalid credentials  |
      #| mochen703@gmail.com  | As5889590.. | Invalid credentials  |
      #| mochen703@gmail.com  |             | Password is required |
      #|                      | As5889590   | Email is required    |
