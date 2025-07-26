package practice08;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class CreateUser {

    @Test
    public void test_CreateUser(ITestContext context){
        Faker faker = new Faker();
        String token = "014f9bf7752974e393ca929cd6a98bbf50413b0e727cbcbec3dfdec4fae24503";

        JSONObject jo = new JSONObject();
        jo.put("name", faker.name().fullName());
        jo.put("email", faker.internet().emailAddress());
        jo.put("gender", "Male");
        jo.put("status", "inactive");
        jo.put("phoneNo", faker.phoneNumber().phoneNumber());

       int id = given()
                .contentType("application/json")
                .headers("Authorization", "Bearer " + token)
                .body(jo.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");

        System.out.println("Generated Id " + id);

        context.setAttribute("user_id",id); // it is for test level
        context.getSuite().setAttribute("user_id",id); // it is for suite level

    }


}
