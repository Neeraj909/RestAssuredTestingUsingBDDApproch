package SerializationAndDeserialization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SerializationAndDeserializationWithout {

    public HashMap map = new HashMap();

    @Test(description = "post request")
    public void createNewStudent() {
        map.put("id", 101);
        map.put("firstName", "neeraj");
        map.put("lastName", "sharma");
        map.put("email", "amit.rhoncus.Proin@massaQuisqueporttitor.org");
        map.put("programme", "manager");
        ArrayList<String> list = new ArrayList<String>();
        list.add("java");
        list.add("selenium");
        map.put("courses", list);
        given()
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .post("http://localhost:8085/student")
                .then()
                .statusCode(201)
                .assertThat()
                .body("msg", equalTo("Student added"));

    }
    @Test(priority = 2)
    public void getStudentRecord(){
        given()
                .when()
                .get("http://localhost:8085/student/101")
                .then()
                .statusCode(200)
                .assertThat()
                .body("id",equalTo(101));
    }

}
