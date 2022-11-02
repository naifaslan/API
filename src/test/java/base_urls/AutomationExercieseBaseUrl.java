package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationExercieseBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void setup(){
        spec= new RequestSpecBuilder().setBaseUri("https://automationexercise.com").build();
    }
}

