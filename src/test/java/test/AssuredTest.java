package test;



import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class AssuredTest {

    @Test
    public void testp() {
//                //Rest API's URL
//         String restAPIUrl = "http://www.pivotaltracker.com/services/v5/me";
//
//         //API Body
//         String apiBody = "{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";
//
//         // Building request by using requestSpecBuilder
//         RequestSpecBuilder builder = new RequestSpecBuilder();
//
//         //Set API's Body
////         builder.setBody(apiBody);
////
//         //Setting content type as application/json
//         builder.setContentType("application/json");
//
//         RequestSpecification requestSpec = builder.build();
//
//         //Making post request with authentication or leave blank if you don't have credentials like: basic("","")
//         Response response = given().auth().basic("areliez.v25@gmail.com", "Control123")
//         .when().request("GET",restAPIUrl);
//            //.spec(requestSpec
//        System.out.println(response.toString());
//
////         JSONObject JSONResponseBody = new JSONObject(response.body().asString());
////
////         //Get the desired value of a parameter
////         String result = JSONResponseBody.getString({key});
////
////         //Check the Result
//         Assert.assertEquals(200, response.getStatusCode());
    }

    public static void main(String[] args) {
        Response res = when().get("https://www.google.com/");

        System.out.println(res.toString());
    }

    public static void main() {

       // RestAssured.baseURI  = "http://api.5min.com/";


    }


}
