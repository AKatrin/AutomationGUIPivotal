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
    Project project;
    private DashboardPage dashboardPage;
    private ProjectAPI projectAPI;

    public ProjectSteps(Context context) {
        this.context = context;
        project = context.getProject();
    }


    @Given("^I have a Project with name \"([^\"]*)\"$")
    public void haveProjectWithName(final String projectName) {
        project.setNameProject(projectName);
        projectAPI = new ProjectAPI();
        try {
            projectAPI.createProject(project);
        } catch (NoCreatedRequierementException ncre) {
            throw new SkipException(ncre.getMessage());
        }
    }

    @When("^I open the Project from Project Dashboard page$")
    public void openTheProjectFromProjectDashboardPage() {
        dashboardPage = new DashboardPage();
        dashboardPage.refresh();
        dashboardPage.naviagteToProject(project.getNameProject());
    }
}
