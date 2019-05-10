package steps;

import cucumber.api.java.en.Given;
import pivotal.ui.LoginPage;
import pivotal.ui.PageTransporter;

/**
 * Created by Yesica on 06/05/2019.
 */
public class LoginSteps {

    PageTransporter pageTransporter = PageTransporter.getInstance();

    // Pages
    private LoginPage loginPage;
//
//    @Given("^I log in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
//    public void logIn(final String userName, final String password) {
//        loginPage = pageTransporter.navigateToLoginPage();
//        loginPage.login(userName, password);
//    }
}
