package steps;

import cucumber.Context;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.SkipException;
import pivotal.api.ProjectAPI;
import pivotal.api.exceptions.NoCreatedRequierementException;
import pivotal.entities.Project;
import pivotal.ui.dashboard.DashboardPage;

public class ProjectSteps {
    Context context;
    Project project = new Project();
    private DashboardPage dashboardPage;
    private ProjectAPI projectAPI;

    @Given("^I have a Project with name \"([^\"]*)\"$")
    public void haveProjectWithName(final String projectName) {
        projectAPI = new ProjectAPI();
        try {
            projectAPI.createProject(projectName);
        } catch (NoCreatedRequierementException ncre) {
            throw new SkipException(ncre.getMessage());
        }
        project.setNameProject(projectName);
        //context.getProject().setNameProject(projectName);
    }

    @When("^I open the Project from Project Dashboard page$")
    public void openTheProjectFromProjectDashboardPage() {
        dashboardPage = new DashboardPage();
        dashboardPage.refresh();
        dashboardPage.naviagteToProject(context.getProject().getNameProject());
    }
}
