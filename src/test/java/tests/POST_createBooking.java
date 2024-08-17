package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import requestBuilder.CreateUserBuilder;
import requests.CreateUser;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class POST_createBooking {
    private CreateUser newUser;
    private CreateUser partialUser;
    private int userId;
    private String token;

    @BeforeTest
    public void testSetUp(){
        CreateUserBuilder builder = new CreateUserBuilder();
        newUser = builder.createUser();
        partialUser = builder.createPartialUser();
    }

    @Test
    public void createBrandNewUser(){
        userId = given().body(newUser)
                .when()
                .post("/api/users")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo(newUser.getName()))
                .body("job",equalTo("Astronaut"))
                .body("id",notNullValue())
                .body("createdAt",notNullValue())
                .extract()
                .path("id");

        System.out.println(userId);
    }
}
