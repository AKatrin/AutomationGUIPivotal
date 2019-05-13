package pivotal.ui.epic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;

import java.util.List;

public class EpicsSection extends BasePage {

    @FindBy(xpath = "//span[@data-aid='EpicPreviewItem__title']")
    private List<WebElement> epics;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    public String getEpicName(String name) {
        WebElement epic = epics.
                stream().
                filter(webElement -> webElement.getText().equals(name)).
                findFirst().
                get();
        return epic.getText();
    }
}
