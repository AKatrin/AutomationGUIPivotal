package pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuLeft extends BasePage{
    @FindBy(xpath = "//*[@id=\"sidebar_area\"]/aside/div/section/section/div/ul/li[6]/button/span")
    private WebElement epicsOptions;
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(epicsOptions));
    }


    public void clickInEpicsOption() {
        epicsOptions.click();
    }
}
