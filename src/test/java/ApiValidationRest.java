import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiValidationRest {

    @Test(priority = 1)
    public void testStatusCode() {

        when()
                .get("https://jsonplaceholder.typicode.com/posts/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    public void testSingleContent() {

        when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .log().all();
    }

    @Test(priority = 3)
    public void testMultipleContent() {

        when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .body("data.first_name", hasItems("Janet", "Emma", "Eve", "Charles"))
                .log().all();
    }


    @Test(priority = 4)
    public void testParamAndHeaders() {

       given()
               .param("MyName","Neeraj")
               .header("MyHeader","India")
               .when()
               .get("https://reqres.in/api/users")
                .then()
               .statusCode(200)
               .log().all();
    }

}
