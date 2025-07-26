package practice08;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    public void test_updateUser(ITestContext context){
        Faker faker = new Faker();
        String token = "014f9bf7752974e393ca929cd6a98bbf50413b0e727cbcbec3dfdec4fae24503";
        int id = (Integer) context.getSuite().getAttribute("user_id");


        JSONObject jo = new JSONObject();
        jo.put("name", faker.name().fullName());
        jo.put("email", faker.internet().emailAddress());
        jo.put("gender", "Male");
        jo.put("status", "active");
        jo.put("phoneNo", faker.phoneNumber().phoneNumber());

                 given()
                .contentType("application/json")
                         .pathParam("id", id)
                         .headers("Authorization", "Bearer " + token)
                .body(jo.toString())
                .when()
                .put("https://gorest.co.in/public/v2/users/{id}")
                         .then()
                         .statusCode(200)
                         .log().all();
    }
}
