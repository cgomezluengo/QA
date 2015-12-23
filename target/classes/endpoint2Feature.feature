Feature: Make a GET request of second empoint

  Scenario: Make a GET request of second endpoint
    Given a get request to second endpoint "http://jsonplaceholder.typicode.com/posts/1/comments"
    When Value a fields of the second endpoint
    Then the status code should be 200
    And has more than 1 comment
    And the "email" fields has in all comments
  