package get_requests;


import base_urls.AutomationExercieseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Odev extends AutomationExercieseBaseUrl {

    /* Given
     https://automationexercise.com/api/productsList
     When
     User sends a GET Request to the url
     Then
     HTTP Status Code should be 200
     And
     Content Type should be "text/html; charset=utf-8"
     And
     Status Line should be HTTP/1.1 200 OK
             And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
    */
    @Test
    public void test1() {
        SoftAssert softAssert = new SoftAssert();
        spec.pathParams("first", "api", "second", "productsList");
        Response response = given().spec(spec).when().get("/{first}/{second}");
        JsonPath jsonPath = response.jsonPath();
        //jsonPath.prettyPrint();

        softAssert.assertEquals(200, response.getStatusCode(), "Status Code Hatalı");
        softAssert.assertEquals("text/html; charset=utf-8", response.getContentType(), "Content Hatalı");
        softAssert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());

        List<String> usertypeMenListi = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Men'}.usertype");
        List<String> usertypeWomenListi = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype");
        List<String> usertypeKidsListi = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Kids'}.usertype");

        softAssert.assertEquals(12,usertypeWomenListi.size(),"Bayan Sayısı 12 Değil ");
        softAssert.assertEquals(9,usertypeMenListi.size());
        softAssert.assertEquals(13,usertypeKidsListi.size());
        softAssert.assertAll(); // perform gibi
    } // Test Not
} // Clas Sonu