package steps;

import cucumber.Context;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pivotal.api.EpicAPI;
import pivotal.api.exceptions.NoCreatedRequierementException;
import pivotal.entities.Epic;
import pivotal.entities.Project;
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
    private Project project;

    public EpicSteps(Context context) {
        this.context = context;
        epicEntity = context.getEpic();
        project = context.getProject();
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

    @And("^I have an Epic with name \"([^\"]*)\"$")
    public void haveAnEpicWithName(String epicName) throws NoCreatedRequierementException {
        project.getId();
        epicEntity.setName(epicName);
        EpicAPI.getInstance().createProject(epicEntity, project);

    }
}
