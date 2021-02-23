Feature: Test HealthCheck with cucumber

  @Issue("PLAT-10399")
  Scenario: Test Health V2 (Given)
    Given I retrieve a 200 response from the v2 health check endpoint

  @Issue("PLAT-10399")
  Scenario: Test Health V2 (Second)
    Given I retrieve a 200 response from the v2 health check endpoint

  @Issue("PLAT-10442")
  Scenario: Test Health V2 (Third)
    Given I retrieve a 200 response from the v2 health check endpoint
