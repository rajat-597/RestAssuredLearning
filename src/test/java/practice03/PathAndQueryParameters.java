package practice03;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
public class PathAndQueryParameters {

    // https://reqres.in/api/users?page=2

    @Test
    public void testPathAndQueryParameters(){
        given()
                .pathParams("myPath", "users")
                .queryParam("page",2)

                .when()
                .get("https://reqres.in/api/{myPath}")

                .then()
                .statusCode(200)
                .log().all();

    }
}
