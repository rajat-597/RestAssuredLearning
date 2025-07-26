package practice08;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetUser {
    @Test
    public void test_getUser(ITestContext context){

        int id = (Integer) context.getSuite().getAttribute("user_id");
        String token = "014f9bf7752974e393ca929cd6a98bbf50413b0e727cbcbec3dfdec4fae24503";

        given()
                .headers("Authorization" , "Bearer " + token)
                .contentType("application/json")
                .pathParam("id" , id)
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
