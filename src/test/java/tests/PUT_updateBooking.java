package tests;

import base.BaseSetUp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requestBuilder.CreateUserBuilder;
import requests.CreateUser;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PUT_updateBooking extends BaseSetUp {
    private CreateUser user;

    @BeforeMethod
    public void testSetUp(){
        CreateUserBuilder userBuilder = new CreateUserBuilder();
        user = userBuilder.createUser();

    }

    @Test
    public void updateUser(){
        given()
                .body("{\"name\":\"updated "+user.getName()+"\",\"job\":\"updated "+user.getJob()+"\"}")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("updated "+user.getName()))
                .body("job", equalTo("updated "+user.getJob()))
                .body("updatedAt", notNullValue())
                .log()
                .all();
    }
}
