package pivotal.ui.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotal.ui.BasePage;
import pivotal.ui.project.MenuLeft;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//section[@class='projectPaneSectionContent']")
    private  WebElement projectPanel;

    @FindBy(xpath = "//a[@data-aid='project-name']")
    private List<WebElement> projectNameLinks;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(projectPanel));
    }

    public MenuLeft navigateToProject(String projectName) {
        WebElement projectNameLink = projectNameLinks.
                stream().
                filter(webElement -> webElement.getText().equals(projectName)).
                findFirst().
                get();
        projectNameLink.click();
        return new MenuLeft();
    }
}
