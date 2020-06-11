import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequest {

    int emp_id = 2;

    @Test
    public void deleteRequest() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/" + emp_id;
        Response response = given().
                when()
                .delete()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").log().all().extract().response();
        String jsonString = response.asString();
        System.out.println(jsonString);

    }
}
