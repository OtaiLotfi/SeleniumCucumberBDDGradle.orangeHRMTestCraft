@orangeHRM-scroll-bar-operations
Feature: orangeHRM Login and PIM operations

  Background:
    Given I open ebay with user ORANGEHRM and password ORANGEHRM
    Then I open "PIM" from the menu

@advanced-vertical-and-horizontal-scroll-bar-operations
Scenario: advanced vertical and horizontal scroll bar operations
  And I click on "Reports" from the top bar
  Then I select all records on the left based on "Name"
  Then I delete records
  And I click on " Add "
  Then I enter the "Report Name" for "DemoE2ETest"
  And I select the wrapper "Include" for "Current and Past Employees"
  And I select the wrapper "Select Display Field Group" for "Contact Details"
  And I click on a white space
  And I click on the add button from the wrapper "Select Display Field"
  And I select the wrapper "Select Display Field Group" for "Personal"
  And I click on a white space
  And I click on the add button from the wrapper "Select Display Field"
  And I select all the "Include Header"
  And I click on " Save "
  And I scroll Scroll to the bottom of the page
  Then I scroll horizontal to the element "Work Email"
  And I scroll to the label "© 2005 - 2024 "
  Then I scroll horizontal to the element "Other Email"
  And I scroll to the label "© 2005 - 2024 "
  Then I play with the vertical and horizontal scroll bar