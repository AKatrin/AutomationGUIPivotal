package pivotal.ui.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;
import pivotal.ui.epic.HeaderPanelEpicComponent;

public class MenuLeft extends BasePage {
    @FindBy(xpath = "//button[@class='panel_toggle']//span[contains(text(),'epics')]")
    private WebElement epicsOptions;

    @FindBy(xpath = "//li[@title='Epics']//button")
    private WebElement epicsBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public HeaderPanelEpicComponent clickInEpicsOption() {
        String valueOfEpicButton = epicsBtn.getAttribute("data-panel-visible");
        if (valueOfEpicButton.equals("false")) {
            epicsBtn.click();
        }
        return new HeaderPanelEpicComponent();
    }
}
