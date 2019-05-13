package pivotal.ui.epic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;


public class EpicFormPage extends BasePage {

    @FindBy(xpath = "//textarea[@name='epic[name]']")
    private WebElement nameField;

    @FindBy(xpath = "//button[@class='autosaves button std save']")
    private WebElement saveBtn;

    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public EpicsSection clickOnSaveBtn() {
        saveBtn.click();
        return new EpicsSection();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
