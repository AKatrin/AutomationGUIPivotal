# new feature
# Tags: optional
#
Feature: A description

@deleteProject
Scenario: Create a new project when user has at least 1 project
    Given I have a Project with name "testProject10"
    And I am logged in pivotal tracker site with username and password valid
    When I open the Project from Project Dashboard page
    And I open Epics section in Project page
    And I add an Epic from epics section in project page with following values
        | name | epic|
    Then I should see the epic in epics section in project page