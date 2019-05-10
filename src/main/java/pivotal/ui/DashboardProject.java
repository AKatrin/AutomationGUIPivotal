package pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardProject extends BasePage {


    @FindBy(xpath="//ol[@class='projectPaneSectionContent__myProjects projectTiles']")
    private WebElement projectsTitles;

    @FindBy(xpath = "//a[@class='projectTileHeader__projectName projectTileHeader__projectName--active']")
    private  WebElement nameProject;
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(projectsTitles));
    }

    public ProjectPage clickOnProject(String projectName) {
        clickOnNameProjectLink();
        return new ProjectPage();

    }

    private void clickOnNameProjectLink() {
        nameProject.click();
    }
}
