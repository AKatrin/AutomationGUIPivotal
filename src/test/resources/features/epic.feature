Feature: Create  and delete an epic

@deleteProject
Scenario: Create an Epic when user has at least 1 project
    Given I have a Project with name "testProject10"
    And I am logged in pivotal tracker site with username and password valid
    When I open the Project from Project Dashboard page
    And I open Epics section in Project page
    And I add an Epic from epics section in project page with following values
        | name | epic|
    Then I should see the epic in epics section in project page

@deleteProject
Scenario: Delete an Epic when user has at least 1 project
    Given I have a Project with name "testProject10"
    And I have an Epic with name "testEpic"
    And I am logged in pivotal tracker site with username and password valid
    When I open the Project from Project Dashboard page
    And I open Epics section in Project page
    When I deleted the epic of Epics section
    Then I should't see the epic in epics section in project page
