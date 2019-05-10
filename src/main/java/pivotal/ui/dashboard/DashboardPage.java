package pivotal.ui.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath="//a[@data-aid='project-name']")
    private List<WebElement> projectNameLinks;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public void naviagteToProject(String projectName) {
        WebElement projectNameLink = projectNameLinks.
                stream().
                filter(webElement -> webElement.getText().equals(projectName)).
                findFirst().
                get();
        projectNameLink.click();
    }
}
