package tests.DummyTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_AllEmployee {

    @Test
    public void getAllEmployee(){
        given().get("https://dummy.restapiexample.com/api/v1/employees")
                .then()
                .statusCode(200);
    }
}
