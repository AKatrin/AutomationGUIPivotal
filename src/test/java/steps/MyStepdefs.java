package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.testng.Assert;
import pivotal.ui.DashboardProject;
import pivotal.ui.LoginPage;
import pivotal.ui.PageTransporter;

public class MyStepdefs {

    PageTransporter pageTransporter = PageTransporter.getInstance();

    // Pages
    private LoginPage loginPage;
    private DashboardProject dashboardProject;

    @Given("^I am logged in pivotal tracker site with (username) and (password) valid$")
    public void logInPivotalTrackerSite(final String userName, final String password) {
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.login(userName, password);
    }

}
