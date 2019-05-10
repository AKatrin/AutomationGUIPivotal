package core.selenium.webdrivers;

import core.selenium.utils.LoaderPropertiesFile;

public class BrowserConfig {
    public static BrowserConfig getInstance() {
        return new BrowserConfig();
    }

    public String getBrowserName() {
        String browserName= LoaderPropertiesFile.getInstance().getProperties().get("browser");
        return browserName;
    }
}
