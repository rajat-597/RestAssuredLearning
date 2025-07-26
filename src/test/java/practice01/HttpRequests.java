package practice01;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;


public class HttpRequests {


    int id;

   // @Test(priority=1)
    public void getUsers(){

        given()
                .when()
                   .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();
    }

    @Test(priority=2)
    public void createUsers(){

      //  HashMap<String,String> data = new HashMap<>();
        JSONObject data = new JSONObject();
        data.put("name","Rajat");
        data.put("job", "SDET");

        id=given()
                .contentType("application/json")
                .body(data.toString())
                .log().all()

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");


              //  .then()
              //     .statusCode(201)
              //     .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUsers"})
    public void update(){

        JSONObject data = new JSONObject();
        data.put("name","Rajat");
        data.put("job", "Automation Tester");

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 4)
    public void deleteUser(){
        given()
                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();
    }

}
