package tests;

import base.BaseSetUp;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import requestBuilder.RegisterNewUserBuilder;
import requests.RegisterUser;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class POST_registerNewUser extends BaseSetUp {
    private RegisterUser newUser;
    private int id;
    private String token;

    @BeforeTest
    public void testSetUp(){
        RegisterNewUserBuilder builder = new RegisterNewUserBuilder();
        newUser = builder.createNewUserforRegister();
    }

    @Test
    public void registerNewUser(){
         Response response = (Response) given().body("{\"email\":\""+newUser.getEmail()+"\",\"password\":\""+newUser.getPassword()+"\"}")
                .when()
                .post("/api/register")
                .then()
                .statusCode(200)
                .body("id",notNullValue())
                .body("token", notNullValue())
                .extract();
         System.out.println(response);

    }

}
