package steps;

import cucumber.api.java.en.And;
import pivotal.ui.LoginPage;
import pivotal.ui.PageTransporter;

public class LoginSteps {

    PageTransporter pageTransporter = PageTransporter.getInstance();

    // Pages
    private LoginPage loginPage;

    @And("^I am logged in pivotal tracker site with (username) and (password) valid$")
    public void logInPivotalTrackerSite(final String userName, final String password) {
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.login(userName, password);
    }

}
