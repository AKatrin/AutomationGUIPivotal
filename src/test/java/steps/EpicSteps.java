package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import pivotal.ui.EpicsPanel;
import pivotal.ui.MenuLeft;

public class EpicSteps {

    private MenuLeft menuLeft;

    private EpicsPanel epicsPanel;
    @When("^I click on the Add Epic button$")
    public void clickOtheAddEpicButton(){
            epicsPanel = new EpicsPanel();
            epicsPanel.clickOnButonAddEpic();
    }
    @When("^I click on Epics$")
    public void clickOnEpics(){
        menuLeft = new MenuLeft();
        menuLeft.clickInEpicsOption();
    }

}
