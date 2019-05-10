package core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.HashMap;

/**
 * Handles Chrome driver initialization.
 */
public class Chrome {
    /**
     * Initializes Chrome driver.
     * @return A new ChromeDriver.
     */
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance().version("74.0.3729.6").setup();

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);

        //Boolean which specifies whether we should ask the user if we should download a file (true) or just download it
        //automatically.
        chromePrefs.put("download.prompt_for_download", "false");

        String path = "C:\\workingSpace";

        File file = new File(path);

        // String which specifies where to download files to by default.
        chromePrefs.put("download.default_directory", file.getAbsolutePath());

        // To avoid alert message when download XML Files.
        chromePrefs.put("safebrowsing.enabled", "true");

        ChromeOptions chromeOptions = new ChromeOptions();
        // Passing the disable-infobars ChromeOption to the WebDriver,
        // prevents Chrome from displaying this notification.
        // -- Chrome is being controlled by automated test software --
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        //Use to ignore ssl errors
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new ChromeDriver(chromeOptions);
    }
}

