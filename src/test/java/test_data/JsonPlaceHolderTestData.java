package test_data;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedData(Integer userId,String title,Boolean completed){

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        return  expectedData;


    }
}
