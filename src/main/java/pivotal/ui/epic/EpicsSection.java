package pivotal.ui.epic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotal.ui.BasePage;

import java.util.ArrayList;
import java.util.List;

public class EpicsSection extends BasePage {

    @FindBy(xpath = "//div[@data-type='epics']")
    private WebElement epicsSection;

    @FindBy(xpath = "//span[@data-aid='EpicPreviewItem__title']")
    private List<WebElement> epics;

    @FindBy(xpath = "//div[@data-type='epics']//a[@data-aid='AddButton']")
    private WebElement AddEpicBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(epicsSection));
    }

    public EpicFormPage clickOnAddEpicBtn() {
        AddEpicBtn.click();
        return new EpicFormPage();
    }

    public List<String> getEpicsName() {
        List<String> epicsName = new ArrayList<>();
        for (WebElement epicName : epics) {
            epicsName.add(epicName.getText());
        }
        return epicsName;
    }
}
