package core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver getManager(BrowserType type) {
        WebDriver driverManager;

        switch (type) {
            case CHROME:
                driverManager = new Chrome().initDriver();
                break;
            case FIREFOX:
                driverManager = new Firefox().initDriver();
                break;
            default:
                driverManager = new Chrome().initDriver();
                break;
        }
        return driverManager;
    }
}
