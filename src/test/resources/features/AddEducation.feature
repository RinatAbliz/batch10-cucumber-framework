Feature: AddEducation

  #@UI @AddEducation
  #Scenario:
  #Given user is on the BoraTech Dashboard page
  #| userName | mochen703@gmail.com |
  #| password | As5889590           |
  #When user is click Add Education
  #And user will be navagit to Add Education Page
  #And user enter the Education Information
  #| school       | George Mason         |
  #| degree       | QA Certifild         |
  #| FieldOfStudy | Automation           |
  #| from         | 02/12/2018           |
  #| to           | 07/12/2022           |
  #| description  | working hard everday |
  #| current      | false                |
  #And user click the submit button
  #Then user will see - "Education Added"
  #@api
  #Scenario: Add Education Api
  #Given [API] User is logged in
  #| userName | mochen703@gmail.com |
  #| password | As5889590           |
  #Then [API] user should be able to add new Education
  #| school       | George Mason         |
  #| degree       | QA Certifild         |
  #| FieldOfStudy | Automation           |
  #| from         | 02/12/2018           |
  #| to           | 07/12/2022           |
  #| description  | working hard everday |
  #| current      | false                |
  @API @UnhappyPath
  Scenario Outline: 
    : Add education unhappy Path API

    Given [API] User is logged in
      | userName | mochen703@gmail.com |
      | password | As5889590           |
    When [API] user try to add new Education
      | school       | <school>       |
      | degree       | <degree>       |
      | FieldOfStudy | <FieldOfStudy> |
      | from         | <from>         |
      | to           | <to>           |
      | description  | <description>  |
      | current      | <current>      |
    Then [API] User should receive error messages
      | errors | <error> |

    Examples: 
      | school   | degree                   | FieldOfStudy  | from       | to         | description | current             | error                                                              |
      |          |                          | QA Automation | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Degree is required, School is required                             |
      | BoraTech |                          | QA Automation | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Degree is required                                                 |
      |          | Test Automation citified | QA Automation | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | School is required                                                 |
      |          |                          |               | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Degree is required, School is required ,Field of study is required |
      | BoraTech | Test Automation citified |               | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Field of study is required                                         |
