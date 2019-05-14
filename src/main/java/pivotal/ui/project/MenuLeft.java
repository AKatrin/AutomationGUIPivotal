package pivotal.ui.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotal.ui.BasePage;
import pivotal.ui.epic.EpicsSection;

public class MenuLeft extends BasePage {

    @FindBy(id = "sidebar_area")
    private WebElement menu;

    @FindBy(xpath = "//li[@title='Epics']//button")
    private WebElement epicsBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(menu));
    }

    public EpicsSection clickInEpicsOption() {
        String valueOfEpicButton = epicsBtn.getAttribute("data-panel-visible");
        if (valueOfEpicButton.equals("false")) {
            epicsBtn.click();
        }
        return new EpicsSection();
    }
}
