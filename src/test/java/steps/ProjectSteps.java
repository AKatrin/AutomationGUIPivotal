package steps;

import cucumber.api.java.en.And;

import org.testng.SkipException;
import org.testng.internal.TestResult;
import pivotal.api.ProjectAPI;
import pivotal.api.exceptions.NoCreatedRequierementException;
import pivotal.ui.dashboard.DashboardPage;

public class ProjectSteps {

    private DashboardPage dashboardPage;
    private ProjectAPI project;

    @And("^I navigate to \"([^\"]*)\" project$")
        public void navigateToProject(String projectName) {
            dashboardPage = new DashboardPage();
            dashboardPage.naviagteToProject(projectName);
            /*WebDriver driver = WebDriverManager.getInstance().getWebDriver();

            String locator = "//a[@data-aid='project-name' and contains(text(),'%s')]";
            String a = String.format(locator, projectName);
            WebElement name = driver.findElement(By.xpath(String.format(locator, projectName)));
            name.click();*/
            String ba = "";
        }

    @And("^I have a Project with name \"([^\"]*)\"$")
    public void haveProjectWithName(String projectName){
        project = new ProjectAPI();
        try {
            project.createProject(projectName);
        } catch (NoCreatedRequierementException ncre) {
            throw new SkipException(ncre.getMessage());
        }
    }
}
