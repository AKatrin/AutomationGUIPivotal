package pivotal.ui;

import core.selenium.utils.LoaderPropertiesFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id="login_type_check_form")
    private WebElement loginForm;

    @FindBy(id="credentials_username")
    private WebElement userNameTextBox;

    @FindBy(css="input[class='app_signin_action_button']")
    private WebElement nextSignInBtn;

    @FindBy(id="credentials_password")
    private WebElement passwordTextBox;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginForm));
    }

    public void login(String userName, String password) {
        setUserName(LoaderPropertiesFile.getInstance().getProperties().get(userName));
        clickNextSignInBtn();
        setPassword(LoaderPropertiesFile.getInstance().getProperties().get(password));
        clickNextSignInBtn();
    }

    private void setPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    private void clickNextSignInBtn() {
        nextSignInBtn.click();
    }

    public void setUserName(String userName) {
        userNameTextBox.sendKeys(userName);
    }
}
