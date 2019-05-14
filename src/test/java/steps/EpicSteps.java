package steps;

import cucumber.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pivotal.entities.Epic;
import pivotal.ui.epic.EpicFormPage;
import pivotal.ui.epic.EpicsSection;
import pivotal.ui.project.MenuLeft;

import java.util.Map;

public class EpicSteps {

    Context context;
    private MenuLeft menuLeft;
    private EpicFormPage epicForm;
    private EpicsSection epicsSection;
    private Epic epicEntity;

    public EpicSteps(Context context) {
        this.context = context;
        epicEntity = context.getEpic();
    }

    @And("^I open Epics section in Project page$")
    public void openEpicsSectionInProjectPage() {
        menuLeft = new MenuLeft();
        epicsSection = menuLeft.clickInEpicsOption();
    }

    @And("^I add an Epic from epics section in project page with following values$")
    public void addAnEpicFromEpicsSectionInProjectPageWithFollowingValues(Map<String, String> epic) {
        epicForm = epicsSection.clickOnAddEpicBtn();
        epicForm.enterName(epic.get("name"));
        epicsSection = epicForm.clickOnSaveBtn();
        epicEntity.setName(epic.get("name"));

    }

    @Then("^I should see the epic in epics section in project page$")
    public void seeTheEpicInEpicsSectionInProjectPage() {
        Assert.assertTrue(epicsSection.getEpicsName().contains(epicEntity.getName()), "The name epic not exist");
    }
}
