package steps;

import cucumber.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pivotal.ui.epic.EpicFormPage;
import pivotal.ui.epic.EpicsSection;
import pivotal.ui.epic.HeaderPanelEpicComponent;
import pivotal.ui.project.MenuLeft;

import java.util.Map;

public class EpicSteps {

    Context context;
    private MenuLeft menuLeft;
    private HeaderPanelEpicComponent epicsPanel;
    private EpicFormPage epicForm;
    private EpicsSection epicsSection;

    @And("^I open Epics section in Project page$")
    public void openEpicsSectionInProjectPage() {
        menuLeft = new MenuLeft();
        epicsPanel = menuLeft.clickInEpicsOption();
    }

    @And("^I add an Epic from epics section in project page with following values$")
    public void addAnEpicFromEpicsSectionInProjectPageWithFollowingValues(Map<String , String> epic) {
        epicForm = epicsPanel.clickOnAddEpicBtn();
        epicForm.enterName(epic.get("name"));
        epicsSection = epicForm.clickOnSaveBtn();
        context.getEpic().setName(epic.get("name"));

    }

    @Then("^I should see the epic in epics section in project page$")
    public void seeTheEpicInEpicsSectionInProjectPage() {
        Assert.assertEquals(context.getEpic().getName(),epicsSection.getEpicName(context.getEpic().getName()));
    }
}
