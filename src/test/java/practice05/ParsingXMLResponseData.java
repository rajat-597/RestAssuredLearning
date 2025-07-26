package practice05;

import com.google.gson.JsonObject;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

// https://www.w3schools.com/xml/simple.xml
public class ParsingXMLResponseData {

 //   @Test
    public void parsingXmlResponse() {

        // approach 1
    /*    given()
                .when()
                .get("https://www.w3schools.com/xml/simple.xml")
                .then()
                .statusCode(200)
                .header("Content-Type","text/xml")
                .body("breakfast_menu.food[0].name",equalTo("Belgian Waffles"))
                .body("breakfast_menu.food[0].price",equalTo("$5.95"))
                .log().all(); */

        // approach 2

        Response res = given()
                .when()
                .get("https://www.w3schools.com/xml/simple.xml");

        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "text/xml");
        String name = res.xmlPath().get("breakfast_menu.food[0].name").toString();
        String price = res.xmlPath().get("breakfast_menu.food[0].price").toString();

        Assert.assertEquals(name, "Belgian Waffles");
        Assert.assertEquals(price, "$5.95");

    }

    @Test
    public void parseXmlResponseObject(){
        Response res = given()
                .when()
                .get("https://www.w3schools.com/xml/simple.xml");

        XmlPath xmlPath = new XmlPath(res.asString());

        // count Total food nodes

       List<String> food = xmlPath.getList("breakfast_menu.food");
       Assert.assertEquals(food.size(),5);

       // get All names and get second name and comes out of loop

      List<String> names =  xmlPath.getList("breakfast_menu.food.name");
      boolean flag = false;
      for(String name:names){
          if(name.equalsIgnoreCase("French Toast")){
              flag = true;
              break;
          }
      }
      Assert.assertEquals(flag, true);
    }
}
