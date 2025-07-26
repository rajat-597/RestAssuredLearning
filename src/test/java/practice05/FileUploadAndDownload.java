package practice05;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FileUploadAndDownload {

    @Test(priority = 1)
    public void singleFileUpload() {
        File filename = new File("C:\\Users\\Rajat179284.CORP\\AutomationProjects\\RestAssuredLearning\\sample1.txt");

        given()
                .multiPart("file", filename)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadFile")
                .then()
                .statusCode(200)
                .body("fileName", equalTo("sample1.txt"))
                .log().all();

    }

    @Test(priority = 2)
    public void downloadFile(){
        given()
                .when()
                .get("http://localhost:8080/downloadFile/sample1.txt")
                .then()
                .statusCode(200)
                .log().body();
    }
}
   // @Test
  /*  public void multipleFileUpload(){
        File file1 = new File("C:\\Users\\Rajat179284.CORP\\AutomationProjects\\RestAssuredLearning\\sample1.txt");
        File file2 = new File("C:\\Users\\Rajat179284.CORP\\AutomationProjects\\RestAssuredLearning\\sample2.txt");

// Approach 1
   /*     given()
                .multiPart("files",file1)
                .multiPart("files",file2)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadMultipleFiles")
                .then()
                .statusCode(200)
                .body("[0].fileName",equalTo("sample1.txt"))
                .log().all();  */


        // Approach 2

    /*    Response res = given()
                .multiPart("files",file1)
                .multiPart("files",file2)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadMultipleFiles");

        boolean status = false;
        JSONArray jsonArray = new JSONArray(res.asString());
        for(int i=0; i<jsonArray.length(); i++){
           JSONObject jo =  jsonArray.getJSONObject(i);
         String fileName =   jo.getString("fileName");
         if(fileName.equalsIgnoreCase("sample2.txt")){
             status =true;
             break;
         }
        }
        Assert.assertEquals(status, true);
    } */
