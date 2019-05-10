package steps;

import cucumber.api.java.en.And;
import pivotal.ui.EpicsPanel;
import pivotal.ui.MenuLeft;

public class EpicSteps {

    private MenuLeft menuLeft;

    private EpicsPanel epicsPanel;

    @And("^I open Epics section in Project page$")
    public void openEpicsSectionInProjectPage() {
        menuLeft = new MenuLeft();
        menuLeft.clickInEpicsOption();
    }
}
