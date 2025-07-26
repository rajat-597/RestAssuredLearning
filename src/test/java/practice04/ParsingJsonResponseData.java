package practice04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

public class ParsingJsonResponseData {

    @Test
    public void testJsonResponse(){

        // Approach 1

     /*   given()
                .contentType("ContentType.JSON")
                .when()
                .get("http://localhost:3000/books")
                .then()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .log().all()
                .body("[1].subtitle",equalTo("A Handbook of Agile Software Craftsmanship")); */

        // Approach 2

      Response res =  given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/books");

   /*   Assert.assertEquals(res.getStatusCode(),200);
      Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
     String subTitleName = res.jsonPath().getString("[1].subtitle").toString();
     Assert.assertEquals(subTitleName , "A Handbook of Agile Software Craftsmanship");
   */
    // [ {...}, {...} ]
        boolean status = false;
        JSONArray jsonArray = new JSONArray(res.asString());
        for(int i=0; i< jsonArray.length(); i++){
          JSONObject jo =  jsonArray.getJSONObject(i);
          String title = jo.getString("title");
          System.out.println("Title contains in Json Objects " + title);
          if(title.equalsIgnoreCase("Clean Code")){
              status = true;
              break;
          }
        }
        Assert.assertEquals(status, true);

        // for { "books": [{...}, {...}] }
      /*  String jsonResponse = res.asString();  // your actual response string
        // Parse the response as a JSONObject
        JSONObject jsonObject = new JSONObject(jsonResponse);
        // Get the array under the "books" key
        JSONArray booksArray = jsonObject.getJSONArray("books");
        use bookArray to iterate like above*/


        // third approach
       /* JSONArray --> JSONObject --> JSONArray(courses)
        JSONArray jarr = new JSONArray(res.asString());
        jarr.getJSONObject(0).getJSONArray("courses").get(1);

        JSONArray --> JSONObject
        JSONArray jarr = new JSONArray(res.asString());
        jarr.getJSONObject(1).get("first_Name");

       JSONObject ---> JSONArray --> JSONObject
       JSONObject jo = new JSONObject(res.asString());
       jo.getJSONArray("books").getJSONObject(i).get("author");
        */
    }
}
