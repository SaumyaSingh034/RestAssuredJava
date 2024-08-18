package tests;

import base.BaseSetUp;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delete_user extends BaseSetUp {

    @Test
    public void deleteUser(){
        given()
                .delete("/api/users/105")
                .then()
                .statusCode(204);
    }

    @Test
    public void getDeletedUser(){
        given()
                .get("/api/users/105")
                .then()
                .statusCode(404);
    }
}
