Feature: Post

  @UI @Post
  Scenario: Create Post
    Given User is logged in
      | userName | mochen703@gmail.com |
      | password | As5889590           |
    When User navigates to the Post page
    And User enter the post content
      | content                                |
      | Cucumber is a lot more than your think |
    And User clink the submit button
    Then user should see a success alert that says - "Post Created"

  #@API
  #Scenario: API-Create Post
    #Given [API] User is logged in
      #| userName | mochen703@gmail.com |
      #| password | As5889590           |
    #Then [API] user should be able to created new post
      #| content                                |
      #| Cucumber is a lot more than your think |
