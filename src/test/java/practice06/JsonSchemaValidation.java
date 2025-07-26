package practice06;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class JsonSchemaValidation {

    @Test
    public void jsonSchemaValidation(){

        given()
                .when()
                .get("http://localhost:3000/travelers")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("travellersJsonSchema.json"));

    }
}
