package tests;

import base.BaseSetUp;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GET_ReqresTest extends BaseSetUp {

  @Test
  public void getListOfUsers(){
      ArrayList<String> data = given().get("/api/users?page=2").then().statusCode(200).assertThat()
              .extract().path("data");
      System.out.println(data);
  }

  @Test
  public void getSpecificUser(){
      Map<String, Object> d = given().get("/api/users/2").then().statusCode(200)
              .extract().path("data");
      System.out.println(d);
  }
}
