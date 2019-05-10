package core.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();
       // FirefoxDriverManager.getInstance().version("0.23.0").setup();
        return new FirefoxDriver();
    }
}
