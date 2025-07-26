package practice08;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class DeleteUser {

    @Test
    public void test_deleteUser(ITestContext context){
        String token = "014f9bf7752974e393ca929cd6a98bbf50413b0e727cbcbec3dfdec4fae24503";
        int id = (Integer) context.getSuite().getAttribute("user_id");

        given()
                .contentType("application/json")
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + token)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(204)
                .log().all();
    }
}
