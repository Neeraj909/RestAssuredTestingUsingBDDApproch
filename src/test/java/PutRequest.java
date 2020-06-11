import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class PutRequest {
    public static Map<String,String> map=new HashMap();
    int emp_id = 21;
    String empName=RestUtils.empName();
    String empSal=RestUtils.empSal();
    String empAge=RestUtils.empAge();

    @BeforeClass
    public void putDataRequest(){
     map.put("employee_name",empName);
     map.put("employee_salary",empSal);
     map.put("employee_age",empAge);
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath="/update/"+emp_id;
    }
    @Test
    public void verifyPutDataRequest(){
        given()
                .contentType("application/json")
                .body(map)
        .when()
                   .put()
        .then()
                .statusCode(200)
                .log().all();

    }

}
