package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class DevowelizerStepsTest {
    private Response response;  //Since it is only one test class entire suite, So, declared the object at class level in this class
    @BeforeClass
    @Given("API base point is available to Test")
    public static void api_Base_Setup() {
        RestAssured.baseURI = "http://localhost:8080/";
    }
    @Test
    @When("I trigger a GET request on API with endpoint as {string}")
    public void trigger_A_GETRequest(String endpoint) {
        try {
              response = RestAssured.get(endpoint);
            } catch(Exception e) {
              System.err.println("Connection refused! Either server is down or the port might be incorrect.");
            }
    }
    @Test
    @Then("the response status should be {int}")
    public void response_Status_ShouldBe(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }
    @Test
    @Then("also, response of API should be {string}")
    public void response_Body_ShouldHave(String expectedBody) {
        assertThat(response.getBody().asString(), equalTo(expectedBody));
    }
}
