package SerializationAndDeserialization;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

public class SerializationAndDeserializationTest {

    @Test(priority = 1)
    public void createNewStudentSerialization() {
        ArrayList<String> list=new ArrayList<String>();
        list.add("java");
        list.add("selenium");
        Student stu=new Student();
        stu.setId(101);
        stu.setFirstName("neeraj");
        stu.setLastName("sharma");
        stu.setProgramme("manager");
        stu.setEmail("neeraj.rhoncus.Proin@massaQuisqueporttitor.org");
        stu.setCourses(list);
        given()
                .contentType(ContentType.JSON)
                .body(stu)
                .when()
                .post("http://localhost:8085/student")
                .then()
                .statusCode(201)
                .assertThat()
                .body("msg", equalTo("Student added"));


    }
    @Test(priority = 2)
    public void getStudentRecordDeserialization(){
        Student stu=get("http://localhost:8085/student/101").as(Student.class);
        System.out.println(stu.toString());
        Assert.assertEquals(stu.getId(),101);

    }

}
