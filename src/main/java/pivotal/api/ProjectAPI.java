package pivotal.api;


import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.Throw;
import pivotal.api.exceptions.NoCreatedRequierementException;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectAPI {
    public void createProject(String projectName) throws NoCreatedRequierementException {
        String restAPIUrl = "https://www.pivotaltracker.com/services/v5/projects";
        Map<String,String> newProject = new HashMap<>();
        newProject.put("name", projectName);
        Response response = given().headers("X-TrackerToken", "e792c5ed8debd0705270e37d8db106e8",
                "Content-Type", "application/json").auth().basic("areliez.v25@gmail.com", "Control123")
                .body(newProject)
                .when().post(restAPIUrl);

        if (response.statusCode() != 200) {
            throw new NoCreatedRequierementException("The project with name '%s' was not created", projectName);
        }
    }
}
