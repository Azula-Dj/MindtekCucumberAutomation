@regression @MB2P-115
Feature: Validating Etsy search and filter functionalities

  Background: Repeated first steps in each scenario.
    Given user navigates to the Etsy application
    When  user searches for "carpet"

  #Before method will run

  Scenario: Validating price filter functionality for searched item

    And   user applies price filter over 1000
    Then  user verifies that item prices are over 1000
    #After method will run

  @smoke
  Scenario: Validating search results

    Then  user validates search results items contains keyword "carpet"

    
