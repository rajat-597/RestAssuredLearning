package practice06;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class XMLSchemaValidator {

    @Test
    public void xmlSchemaValidation(){

        given()
                .when()
                .get("https://www.w3schools.com/xml/simple.xml")
                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("foodXmlSchema.xsd"));
    }
}
