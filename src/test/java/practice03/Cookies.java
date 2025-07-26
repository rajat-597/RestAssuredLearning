package practice03;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

import java.util.Map;

public class Cookies {

    @Test(priority = 1)
    public void getCookieDetails() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200)
                .cookie("AEC", "AVh_V2jk98l6WAP37lvOfXRZFw9ZDEA7QgQWl-GeqKRP3FW_Sc1-UuE-JFU")
                .log().all();

    }

   @Test(priority = 2)
    public void getCookieInfo(){
    Response res = given()
               .when()
               .get("https://www.google.com/")
               .then()
               .statusCode(200)
               .log().all()
               .extract().response();

    // to get single cookie value  (Capture cookies from response)
         String cookies_name = res.getCookie("AEC");
       System.out.println("Cookies name is "+ cookies_name);

       // to get all the cookies
      Map<String,String> data =  res.getCookies();
      for(String k: data.keySet()){
          String cookies_value =  res.getCookie(k);
          System.out.println(k + "----" + cookies_value);
      }

   }

}
