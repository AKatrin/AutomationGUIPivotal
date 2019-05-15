package pivotal.api;

import io.restassured.response.Response;
import pivotal.api.exceptions.NoCreatedRequierementException;
import pivotal.entities.Epic;
import pivotal.entities.Project;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EpicAPI extends BaseAPI {

    private static final String ENDPOINT_EPIC = "/projects/$PROJECT_ID/epics";

    public void createProject(Epic epic, Project project) throws NoCreatedRequierementException {
        String baseUrl = apiBaseURL.concat(ENDPOINT_EPIC);
        Map<String, String> newProject = new HashMap<>();
        newProject.put("name", project.getNameProject());
        Response response = given()
                .headers(X_TRACKER_TOKEN, super.trackerTokenValue,
                        CONTENT_TYPE, super.contentTypeValue)
                .body(newProject)
                .when().post(baseUrl);

        if (response.statusCode() != 200) {
            throw new NoCreatedRequierementException("The epic with name '%s' was not created", project.getNameProject());
        }
        project.setId(response.body().jsonPath().getInt("id"));
    }
    public static EpicAPI getInstance() {
        return new EpicAPI();
    }
}
