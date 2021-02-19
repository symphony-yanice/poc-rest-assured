Feature: Test HealthCheck with cucumber

  Scenario: Test Health V2 (Given)
    Given I retrieve a 200 response from the v2 health check endpoint

  Scenario: Test Health V2 (When)
    When I retrieve a 200 response from the v2 health check endpoint

  Scenario: Test Health V2 (Then)
    Then I retrieve a 200 response from the v2 health check endpoint