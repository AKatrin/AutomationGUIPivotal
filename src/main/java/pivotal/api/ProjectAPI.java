package pivotal.api;

import core.selenium.utils.LoaderPropertiesFile;
import io.restassured.response.Response;
import pivotal.api.exceptions.NoCreatedRequierementException;
import pivotal.entities.Project;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectAPI {

    private static final String ENDPOINT_PROJECTS = "/projects";

    /**
     * Header name for the token.
     */
    private static final String X_TRACKER_TOKEN = "X-TrackerToken";

    /**
     * Header value for the token.
     */
    private static final String TRACKER_TOKEN_VALUE = LoaderPropertiesFile.getInstance().getProperties().get(X_TRACKER_TOKEN);
    /**
     * Header name for the content type.
     */
    private static final String CONTENT_TYPE = "Content-Type";

    /**
     * Header value for content type.
     */
    private static final String CONTENT_TYPE_VALUE = LoaderPropertiesFile.getInstance()
            .getProperties().get(CONTENT_TYPE);

    /**
     * Base url to do requests by API.
     */
    private String apiBaseURL = LoaderPropertiesFile.getInstance().getProperties().get("urlAPI");

    /**
     * Create a project only with requirement fields.
     * @param project for get the requirement fields.
     * @throws NoCreatedRequierementException if the project wasn't created.
     */
    public void createProject(Project project) throws NoCreatedRequierementException {
        String baseUrl = apiBaseURL.concat(ENDPOINT_PROJECTS);
        Map<String, String> newProject = new HashMap<>();
        newProject.put("name", project.getNameProject());
        Response response = given()
                .headers("X-TrackerToken", "e792c5ed8debd0705270e37d8db106e8",
                        "Content-Type", "application/json")
                .body(newProject)
                .when().post(baseUrl);

        if (response.statusCode() != 200) {
            throw new NoCreatedRequierementException("The project with name '%s' was not created", project.getNameProject());
        }
        project.setId(response.body().jsonPath().getInt("id"));
    }

    /**
     * Delete a project sending the id.
     * @param idProject for concat to the url.
     */
    public void deleteProject(int idProject) {
        System.out.println(idProject);
        String idProjectAsString = String.valueOf(idProject);
        String baseUrl = apiBaseURL.concat(ENDPOINT_PROJECTS).concat("/" + idProjectAsString);
        Response response = given()
                .headers("X-TrackerToken", "e792c5ed8debd0705270e37d8db106e8",
                        "Content-Type", "application/json")
                .when().delete(baseUrl);
    }
}
