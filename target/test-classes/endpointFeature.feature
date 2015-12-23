Feature: Make a GET request for first endpoint

  Scenario: Make a GET request first endpoint
    Given a get request to "http://jsonplaceholder.typicode.com/posts/1"
    When Value a fields of the first endpoint
    Then the status code should be 200
    And fields userId should be 1
    And id should be 1
    And fields title  dont be null
    And body don't be null
