package practice02;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import org.json.JSONObject;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// post with Hashmap
// post with org.json
// post with POJO
// post with external file
public class DifferentWaysToCreatePostBody {

    String studentId;
  //  @Test(priority = 1)

    public void createPostBodyWithHashmap(){
        HashMap data = new HashMap<>();
        data.put("name","Rahul");
        data.put("phone","720549");
        data.put("location","Keonjhar");

        String courseArr [] = {"RMJ","ControlM"};

        data.put("courses",courseArr);

        Response response =  given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Rahul"))
                .body("location",equalTo("Keonjhar"))
                .body("courses[0]",equalTo("RMJ"))
                .body("courses[1]",equalTo("ControlM"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all()
                .extract().response();

        studentId = response.jsonPath().getString("id");

    }

  //  @Test(priority = 2)

    public void deleteUsers(){
        given()
                .when()
                .delete("http://localhost:3000/students/"+studentId)
                .then()
                .statusCode(200)
                .log().all();
    }

    // Create Post Data with jsonLibrary

    // @Test(priority = 1)
    public void createPostBodyWithJsonApi(){
        JSONObject data1 = new JSONObject();
        data1.put("name","Roshan");
        data1.put("phone","720543");
        data1.put("location","BBSR");

        String courseArr [] = {"DBA","MongoDB"};

        data1.put("courses",courseArr);

        Response response =  given()
                .contentType("application/json")
                .body(data1.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Roshan"))
                .body("location",equalTo("BBSR"))
                .body("courses[0]",equalTo("DBA"))
                .body("courses[1]",equalTo("MongoDB"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all()
                .extract().response();

        studentId = response.jsonPath().getString("id");

    }

   // @Test(priority = 2)

    public void deleteUsersForJsonApi(){
        given()
                .when()
                .delete("http://localhost:3000/students/"+studentId)
                .then()
                .statusCode(200)
                .log().all();
    }


    // Create Post Data with POJO class

  //  @Test(priority = 1)
    public void createPostBodyWithPOJO(){
       Pojo_DataSetup data2 = new Pojo_DataSetup();
       data2.setName("Sovan");
       data2.setLocation("Cuttack");
       data2.setPhoneNo("54638");

       String courseArr [] = {"LLB","Civil"};
       data2.setCourses(courseArr);


        Response response =  given()
                .contentType("application/json")
                .body(data2)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Sovan"))
                .body("location",equalTo("Cuttack"))
                .body("courses[0]",equalTo("LLB"))
                .body("courses[1]",equalTo("Civil"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all()
                .extract().response();

        studentId = response.jsonPath().getString("id");

    }

   // @Test(priority = 2)

    public void deleteUsersForJsonPOJO(){
        given()
                .when()
                .delete("http://localhost:3000/students/"+studentId)
                .then()
                .statusCode(200)
                .log().all();
    }

    // Create Post Data with External File

    @Test(priority = 1)
    public void createPostBodyWithExternalFile() throws FileNotFoundException {

        File f = new File(".\\body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data3 = new JSONObject();

        // same thing as second approach after that

        Response response =  given()
                .contentType("application/json")
                .body(data3.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Sovan"))
                .body("location",equalTo("Cuttack"))
                .body("courses[0]",equalTo("LLB"))
                .body("courses[1]",equalTo("Civil"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all()
                .extract().response();

        studentId = response.jsonPath().getString("id");

    }

    @Test(priority = 2)

    public void deleteUsersForExternalFile(){
        given()
                .when()
                .delete("http://localhost:3000/students/"+studentId)
                .then()
                .statusCode(200)
                .log().all();
    }
}
