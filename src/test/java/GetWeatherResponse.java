import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetWeatherResponse {

    @Test
    public void getResponse() {

        Response response = given().
                when().
                get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("City", equalTo("Hyderabad"))
                .header("content-Type", "application/json").extract().response();
        String jsonString = response.asString();
        System.out.println(jsonString);
    }


}
