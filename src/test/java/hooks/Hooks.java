package hooks;


import cucumber.Context;
import cucumber.api.java.After;
import pivotal.api.ProjectAPI;

public class Hooks {
    Context context;
    public Hooks(Context context) {
        this.context = context;
    }

    @After("@deleteProject")
    public void afterScenario(){
        ProjectAPI.getInstance().deleteProject(context.getProject().getId());
    }
}
