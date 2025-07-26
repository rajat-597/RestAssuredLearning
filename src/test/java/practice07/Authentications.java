package practice07;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authentications {

  /*  @Test(priority =1)
    public void basicAuthenticate(){

        given()
                .auth().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    } */

   /* @Test(priority = 2)
    public void digestAuthenticate(){

        given()
                .auth().digest("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    } */

   /* @Test(priority = 3)
    public void preemptiveAuthenticate(){

        given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    } */

   /* @Test
    public void bearerTokenAuthenticate() {

        given()
                .headers("Authorization", "provide Bearer token")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();

    } */

   /* @Test(priority = 5)
    public void oAuth1TokenAuthenticate() {

        given()
                .auth().oauth("consumerKey","consumerSecret", "accessToken" ,"tokenSecret")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();

    } */

  /*  @Test(priority = 6)
    public void oAuth2TokenAuthenticate() {

        given()
                .auth().oauth2("provide token")
                .when()
                .get("https://api.github.com/user")
                .then()
                .statusCode(200)
                .log().all();

    } */

    @Test
    public void apiKeysAuthenticate() {

        given()
                .queryParam("testId", "ajhsfdthsdhahgchg123sbncv")
                .when()
                .get("https://api.github.com/user")
                .then()
                .statusCode(200)
                .log().all();

        // note we are mostly passing API keys in queryParam() or headers() .
    }
}