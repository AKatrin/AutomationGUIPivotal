package pivotal.ui;

import core.selenium.webdrivers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = WebDriverManager.getInstance().getWebDriver();
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    protected abstract void waitUntilPageObjectIsLoaded();
}
