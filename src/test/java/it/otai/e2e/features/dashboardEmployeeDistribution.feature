@orangeHRM-Dashboard-Employee-Distribution
Feature: orangeHRM Dashboard Employee Distribution

  Background:
    Given I open ebay with user ORANGEHRM and password ORANGEHRM

  @Employee-Distribution-by-Sub-Unit-and-Location
  Scenario: Employee Distribution by Sub Unit and Location
    When I scroll to the label "Employee Distribution by Sub Unit"
    Then I click on the legend key "Unassigned"
    And I click on the legend key "Human Resources"
    And I click on the legend key "Engineering"
    And I click on the legend key "Administration"
    And I click on the legend key "Client Services"
    And I click on the legend key "Client Services"
    And I click on the legend key "Administration"
    And I click on the legend key "Engineering"
    And I click on the legend key "Human Resources"
    And I click on the legend key "Unassigned"
    When I scroll to the label "Employee Distribution by Location"
    Then I click on the legend key "Unassigned"
    Then I click on the second legend key "Unassigned"
    And I click on the legend key "Texas R&D"
    And I click on the legend key "New York Sales Office"
    And I click on the legend key "New York Sales Office"
    And I click on the legend key "Texas R&D"
    Then I scroll the Dashboard page