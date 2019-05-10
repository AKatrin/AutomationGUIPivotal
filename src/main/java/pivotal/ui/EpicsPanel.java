package pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EpicsPanel extends BasePage{
    @FindBy(xpath = "//*[@id=\"panel_epics_2346260\"]/div/header/div")
    private WebElement menuheader;
    @FindBy(xpath = "//*[@id=\"panel_epics_2346260\"]/div/header/div/div[3]/div/a")
    private WebElement buttonToAddEpic;
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(buttonToAddEpic));

    }

    public void clickOnButonAddEpic() {
        try {
            Thread.sleep(500000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        buttonToAddEpic.click();
    }
}
