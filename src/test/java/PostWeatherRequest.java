import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PostWeatherRequest {
    public static Map<String, String> map = new HashMap();

    @BeforeClass
    public void postDataRequest() {
        map.put("FirstName", RestUtils.getFirstName());
        map.put("LastName", RestUtils.getLastName());
        map.put("UserName", RestUtils.getUserName());
        map.put("Password", RestUtils.getPassword());
        map.put("Email", RestUtils.getEmail());
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RestAssured.basePath = "/register";

    }

    @Test
    public void validatePostData() {
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .post()
                .then()
                .statusCode(201)
                .and()
                .body("SuccessCode", equalTo("OPERATION_SUCCESS"))
                .and()
                .body("Message", equalTo("Operation completed successfully"));

    }

}
