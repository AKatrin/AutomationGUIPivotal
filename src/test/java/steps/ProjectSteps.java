package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.testng.SkipException;
import pivotal.api.ProjectAPI;
import pivotal.api.exceptions.NoCreatedRequierementException;
import pivotal.entities.Project;
import pivotal.ui.dashboard.DashboardPage;

public class ProjectSteps {

    Project project;
    private DashboardPage dashboardPage;
    private ProjectAPI projectAPI;

    @And("^I navigate to \"([^\"]*)\" project$")
    public void navigateToProject(String projectName) {
        dashboardPage = new DashboardPage();
        dashboardPage.naviagteToProject(projectName);
    }

    @And("^I have a Project with name \"([^\"]*)\"$")
    public void haveProjectWithName(String projectName) {
        projectAPI = new ProjectAPI();
        try {
            projectAPI.createProject(projectName);
        } catch (NoCreatedRequierementException ncre) {
            throw new SkipException(ncre.getMessage());
        }
        project = new Project(projectName);
    }

    @When("^I open the Project from Project Dashboard page$")
    public void openTheProjectFromProjectDashboardPage() {
        dashboardPage = new DashboardPage();
        dashboardPage.refresh();
        dashboardPage.naviagteToProject(project.getNameProject());
    }
}
