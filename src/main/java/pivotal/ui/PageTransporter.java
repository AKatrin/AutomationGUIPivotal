package pivotal.ui;

import core.selenium.utils.LoaderPropertiesFile;
import core.selenium.webdrivers.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class PageTransporter {

    private static PageTransporter instance;
    WebDriver webDriver;
    String baseURL = "https://www.pivotaltracker.com/";

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    private void goToURL(final String url) {
        try {
            webDriver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public LoginPage navigateToLoginPage() {

        goToURL(baseURL.concat("signin"));
        return new LoginPage();
    }
}
