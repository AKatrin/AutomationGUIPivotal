package pivotal.api;


import core.selenium.utils.LoaderPropertiesFile;
import cucumber.Context;
import io.restassured.response.Response;
import pivotal.api.exceptions.NoCreatedRequierementException;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectAPI {

    private String apiBaseURL = LoaderPropertiesFile.getInstance().getProperties().get("urlAPI");
    private static final String endpointProjects = "/projects";

    public void createProject(String projectName) throws NoCreatedRequierementException {
        String baseUrl = apiBaseURL.concat(endpointProjects);
        Map<String,String> newProject = new HashMap<>();
        newProject.put("name", projectName);
        Response response = given()
                .headers("X-TrackerToken", "e792c5ed8debd0705270e37d8db106e8",
                "Content-Type", "application/json")
                .body(newProject)
                .when().post(baseUrl);

        if (response.statusCode() != 200) {
            throw new NoCreatedRequierementException("The project with name '%s' was not created", projectName);
        }
    }

}
