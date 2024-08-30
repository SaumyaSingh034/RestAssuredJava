package tests;

import base.BaseSetUp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import requestBuilder.CreateUserBuilder;
import requests.CreateUser;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class POST_createBooking extends BaseSetUp {
    private CreateUser newUser;
    private CreateUser partialUser;
    private String userId;
    private String token;

    @BeforeTest
    public void testSetUp(){
        CreateUserBuilder builder = new CreateUserBuilder();
        newUser = builder.createUser();
        partialUser = builder.createPartialUser();
    }

    @Test
    public void createBrandNewUser(){
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name",newUser.getName());
        jsonAsMap.put("job",newUser.getJob());
        userId = given().contentType(ContentType.JSON).
                body("{\"name\":\""+newUser.getName()+"\",\"job\":\""+newUser.getJob()+"\"}")
        //body(jsonAsMap)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .assertThat()
                .body("name",equalTo(newUser.getName()))
                .body("job",equalTo("Astronaut"))
               .body("id",notNullValue())
                .body("createdAt",notNullValue())
                .extract()
                .path("id");

        System.out.println(userId);

    }

    @Test
    public void createPartialUser(){
        userId = given().
                contentType(ContentType.JSON)
                .body("{\"name\":\""+partialUser.getName()+"\",\"job\":\"\"}")
                //body(jsonAsMap)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .assertThat()
                .body("name",equalTo(partialUser.getName()))
                .extract()
                .path("id");



        

    }
    
    @Test
    public void oAuth_Autherization(){
        Response response = given().header("authorization","Bearer "+token)
                .contentType(ContentType.JSON)
                .formParam("clientId", userId)
                .queryParam("scope", newUser)
                .post("/oauth2/authorize")
                .then()
                .statusCode(200)
                .extract()
                .response();


        response.jsonPath().get("token");

        //to get headers
        response.getHeaders();


    }
}
