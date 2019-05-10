package pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuLeft extends BasePage {
    @FindBy(xpath = "//button[@class='panel_toggle']//span[contains(text(),'epics')]")
    private WebElement epicsOptions;

    @FindBy(xpath = "//li[@title='Epics']//button")
    private WebElement epicsBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public void clickInEpicsOption() {
        String valueOfEpicButton = epicsBtn.getAttribute("data-panel-visible");
        System.out.println(valueOfEpicButton);
        if (valueOfEpicButton.equals("false")) {
            epicsBtn.click();
        }
    }
}
