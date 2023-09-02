Feature: AddEducation

  @UI @AddEducation
  Scenario: 
    Given user is on the BoraTech Dashboard page
      | userName | mochen703@gmail.com |
      | password | As5889590           |
    When user is click Add Education
    And user will be navagit to Add Education Page
    And user enter the Education Information
      | school       | George Mason         |
      | degree       | QA Certifild         |
      | FieldOfStudy | Automation           |
      | from         | 02/12/2018           |
      | to           | 07/12/2022           |
      | description  | working hard everday |
      | current      | false                |
    And user click the submit button
    Then user will see - "Education Added"
