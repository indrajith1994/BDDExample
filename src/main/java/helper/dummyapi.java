package helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class dummyapi {
    static Response response = null;

    @Given("Reach endpoint url {string}")
    public void reachEndpointUrl(String arg0) {
        RestAssured.baseURI = arg0;
    }

    @When("Hit the post request")
    public void hitThePostRequest() {
        response = RestAssured
                .given().log().all().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .when().post("/api/v1/create")
                .then().log().all().extract().response();

    }

    @Then("I should validate the response code and response body after Post request")
    public void iShouldValidateTheResponseCodeAndResponseBodyAfterPostRequest() {
        System.out.println(response.getStatusCode());
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }
}
