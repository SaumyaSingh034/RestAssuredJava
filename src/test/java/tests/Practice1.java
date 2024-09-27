package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Practice1 {
    @Test
    public void getCall() {
         RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        given().when().get("/booking").then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void getCallFilterByName(){
        RestAssured.baseURI ="https://restful-booker.herokuapp.com";
        Response response = given().queryParam("firstname","sally" )
                .queryParam("lastname","brown")
                .when()
                .get("/booking")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();
    }

    @Test
    public void postCallWithValidation(){

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().queryParam("key","qaclick123")
                .header("Content-Type", "application/json")
                .when()
                .post("maps/api/place/add/json")
                .then()
                .log()
                .all()
                .statusCode(200);

    }
}
