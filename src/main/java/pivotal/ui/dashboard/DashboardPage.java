package pivotal.ui.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;
import pivotal.ui.MenuLeft;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//a[@data-aid='project-name']")
    private List<WebElement> projectNameLinks;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public MenuLeft naviagteToProject(String projectName) {
        refresh();
        WebElement projectNameLink = projectNameLinks.
                stream().
                filter(webElement -> webElement.getText().equals(projectName)).
                findFirst().
                get();
        projectNameLink.click();
        return new MenuLeft();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
