package pivotal.ui.epic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;

public class HeaderPanelEpicComponent extends BasePage {

    @FindBy(xpath = "//div[@data-type='epics']//a[@data-aid='AddButton']")
    private WebElement buttonToAddEpic;

    public EpicFormPage clickOnAddEpicBtn() {
        buttonToAddEpic.click();
        return new EpicFormPage();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {}
}
