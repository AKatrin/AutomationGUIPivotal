package hooks;


import cucumber.Context;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pivotal.api.ProjectAPI;

public class Hooks {
    ProjectAPI projectAPI;
    Context context;
    public Hooks(Context context) {
        this.context = context;
    }
    @After("@deleteProject")
    public void afterScenario(){
        projectAPI = new ProjectAPI();
        projectAPI.deleteProject(context.getProject().getId());
    }
}
