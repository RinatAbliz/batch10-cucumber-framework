Feature: Post

  #@UI @Post
  #Scenario: Create Post
  #Given User is logged in
  #| userName | mochen703@gmail.com |
  #| password | As5889590           |
  #When User navigates to the Post page
  #And User enter the post content
  #| content                                |
  #| Cucumber is a lot more than your think |
  #And User clink the submit button
  #Then user should see a success alert that says - "Post Created"
  #@API
  #Scenario: API-Create Post
  #Given [API] User is logged in
  #| userName | mochen703@gmail.com |
  #| password | As5889590           |
  #Then [API] user should be able to created new post
  #| content                                |
  #| Cucumber is a lot more than your think |
  @UI @API @End-to-End
  Scenario: Post End-to-End Test
    Given [API] User is logged in
      | userName | mochen703@gmail.com |
      | password | As5889590           |
    Then [API] user should be able to created new post
      | content                                |
      | Cucumber is a lot more than your think |
    Given User is logged in
      | userName | mochen703@gmail.com |
      | password | As5889590           |
    When User navigates to the Post page
    Then user should see the post that was created previously
    When user deleted the post that was created previously
    Then [API] user can validate that the post they created previously is not there anymore
