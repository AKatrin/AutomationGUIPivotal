package steps;

import cucumber.Context;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pivotal.api.ProjectAPI;
import pivotal.api.exceptions.NoCreatedRequierementException;
import pivotal.entities.Project;
import pivotal.ui.dashboard.DashboardPage;

public class ProjectSteps {

    Context context;
    Project project;
    private DashboardPage dashboardPage;

    public ProjectSteps(Context context) {
        this.context = context;
        project = context.getProject();
    }

    @Given("^I have a Project with name \"([^\"]*)\"$")
    public void haveProjectWithName(final String projectName){
        project.setNameProject(projectName);
        try {
            ProjectAPI.getInstance().createProject(project);
        } catch (NoCreatedRequierementException ncrw) {
            ncrw.printStackTrace();
        }
    }

    @When("^I open the Project from Project Dashboard page$")
    public void openTheProjectFromProjectDashboardPage() {
        dashboardPage = new DashboardPage();
        dashboardPage.navigateToProject(project.getNameProject());
    }
}
