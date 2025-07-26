package practice03;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class HeadersInfo {

    @Test(priority = 1)
    public void getHeaderInfo() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200)
                .header("Content-Encoding", "gzip")
                .header("Server", "gws")
                .header("P3P", "CP=\"This is not a P3P policy! See g.co/p3phelp for more info.\"")
                .log().all();

    }

    @Test(priority = 2)
    public void getHeaderDetails() {
        Response res = given()
                .when()
                .get("https://www.google.com/");


        // to extract single header
   //    String header =  res.header("Content-Encoding");
     //   System.out.println("Header name is "+ header);

        // to extract all headers

        Headers headers = res.getHeaders();

        for (Header header : headers) {
            System.out.println(header.getName() + " : " + header.getValue());
        }
    }
}