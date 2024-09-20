package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NestedJSONResponseFetch {

    @Test
    public void jsonAryValue() {

        //base URI with Rest Assured class
        RestAssured.baseURI = "https://run.mocky.io/v3";

        //obtain Response from GET request
        Response res = given()
                .when()
                .get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7")
                .then()
                .log()
                .all().extract().response();

        //convert JSON to string
        JsonPath j = new JsonPath(res.asString());

        //Zip for 2nd Location array
        String zip = j.getString("Location[1].zip");
        System.out.println("Zip for 2nd Location array: " + zip);
    }
}
