Feature: LoginApi

  @api
  Scenario Outline: 
    Given call login api with "<email>" and "<password>"
    Then we should get response code <code>

    Examples: 
      | email                | password    | code |
      | mochen703@gmail.com  | As5889590.. |  400 |
      | rinatabliz@gmail.com | As5889590   |  400 |
      | mochen703@gmail.com  | As5889590   |  200 |
