package steps;

import cucumber.api.java.en.And;

import pivotal.ui.dashboard.DashboardPage;

public class ProjectSteps {

    private DashboardPage dashboardPage;

    @And("^I navigate to \"([^\"]*)\" project$")
        public void navigateToProject(String projectName) {
            dashboardPage = new DashboardPage();
            dashboardPage.naviagteToProject(projectName);
            /*WebDriver driver = WebDriverManager.getInstance().getWebDriver();

            String locator = "//a[@data-aid='project-name' and contains(text(),'%s')]";
            String a = String.format(locator, projectName);
            WebElement name = driver.findElement(By.xpath(String.format(locator, projectName)));
            name.click();*/
            String ba = "";
        }

    @And("^I have a Project with name \"([^\"]*)\"$")
    public void haveProjectWithName(String projectName){
//
//            RestAssured.baseURI  = "https://www.pivotaltracker.com/services/v5";
//
//        Response res = given()
//                .contentType("application/json").
//                        body("\"name\":\"Executioner\"").
//                        when().
//                        post("https://www.pivotaltracker.com/services/v5/projects");
//
//        String body = res.getBody().asString();
//        System.out.println(body);


    }
}
