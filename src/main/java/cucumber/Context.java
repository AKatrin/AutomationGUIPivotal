package cucumber;

import pivotal.entities.Epic;
import pivotal.entities.Project;

public class Context {

    private Project project;
    private Epic epic;

    public Context() {
        project = new Project();
        epic = new Epic();
    }

    public Project getProject() {
        return project;
    }

    public Epic getEpic() {
        return epic;
    }
}
