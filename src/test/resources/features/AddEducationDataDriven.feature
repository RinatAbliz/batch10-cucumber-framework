@AddEducationDataDriven
Feature: Add Education

  #@UI
  #Scenario Outline: happy Path
  #Given user is on the BoraTech Dashboard page
  #| email    | mochen703@gmail.com |
  #| password | As5889590           |
  #When user is click Add Education
  #And user will be navagit to Add Education Page
  #And user enter the Education Information
  #| school       | <school>       |
  #| degree       | <degree>       |
  #| FieldOfStudy | <FieldOfStudy> |
  #| from         | <from>         |
  #| to           | <to>           |
  #| description  | <description>  |
  #| current      | <current>      |
  #And user click the submit button
  #Then user will see Alert
  #| alerts | <alert> |
  #
  #Examples:
  #| school       | degree       | FieldOfStudy | from       | to         | description          | current | alert           |
  #| George Mason | QA Certifild | Automation   | 02/12/2018 | 07/12/2022 | working hard everday | false   | Education Added |
  @UI
  Scenario Outline: unHappy Path
    Given user is on the BoraTech Dashboard page
      | email    | mochen703@gmail.com |
      | password | As5889590           |
    When user is click Add Education
    And user will be navagit to Add Education Page
    And user enter the Education Information
      | school       | <school>       |
      | degree       | <degree>       |
      | FieldOfStudy | <FieldOfStudy> |
      | from         | <from>         |
      | to           | <to>           |
      | description  | <description>  |
      | current      | <current>      |
    And user click the submit button
    Then user will see ErrorAlert
      | alerts | <alert> |

    Examples: 
      | school   | degree                   | FieldOfStudy  | from       | to         | description | current             | alert                                                              |
      |          |                          | QA Automation | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Degree is required, School is required                             |
      | BoraTech |                          | QA Automation | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Degree is required                                                 |
      |          | Test Automation citified | QA Automation | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | School is required                                                 |
      |          |                          |               | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Degree is required, School is required ,Field of study is required |
      | BoraTech | Test Automation citified |               | 2022-01-12 | 2023-01-01 | false       | Studay hard everday | Field of study is required                                         |
