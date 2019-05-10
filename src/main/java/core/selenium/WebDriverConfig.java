package core.selenium;

import core.selenium.utils.LoaderPropertiesFile;

import java.util.Properties;

/**
 * Class to manage the config of web driver.
 */
public class WebDriverConfig {

    private static final String BROWSER = "browser";
    private  static final String IMPLICIT = "implicitWaitTime";
    private  static final String EXPLICIT = "explicitWaitTime";
    private  static final String WAIT_SLEEP_TIME = "waitSleepTime";

    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;

    private static WebDriverConfig instance;

    protected WebDriverConfig() {
        initialize();
    }
    /**
     * Constructor of WebDriverConfig.
     * Gets WebDriverConfig as Singleton.
     *
     * @return a instance.
     */
    public static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }

        return instance;
    }

    /**
     * Initializes WebDriverConfig.
     */
    public void initialize() {
        //browser = System.getProperty(BROWSER);  //Get the browser system property
        implicitWaitTime = Integer.parseInt(LoaderPropertiesFile.getInstance().getProperties().get(IMPLICIT));
        explicitWaitTime = Integer.parseInt(LoaderPropertiesFile.getInstance().getProperties().get(EXPLICIT));
        waitSleepTime = Integer.parseInt(LoaderPropertiesFile.getInstance().getProperties().get(WAIT_SLEEP_TIME));
    }

    /**
     * Gets the browser in which the tests are being executed.
     *
     * @return Browser.
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return The implicit time.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time set for the WebDriver.
     *
     * @return The explicit time.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Gets the sleep time wait set for the WebDriver.
     *
     * @return Sleep time wait.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
