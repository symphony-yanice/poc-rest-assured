Feature: Test HealthCheck with cucumber

  Scenario: Test Health V2
    Given that I retrieve a response from the health check endpoint
    When I receive a 200 status code from a response
    Then all the V2 Health Check fields are present