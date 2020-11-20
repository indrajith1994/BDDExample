package APIUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class UserScenariosTest {

    private String path;
    private Response response;

    private String validRequest = "{\n" +
            "  \"username\": \"test-api-user\",\n" +
            "  \"email\": \"test-api-user@email.com\",\n" +
            "  \"password\": \"Passw0rd123!\",\n" +
            "  \"name\": \"Test Api-User\" \n}";

    @Given("the users endpoint exists")
    public void preReq() {
        RestAssured.baseURI = "https://localhost:8080";
        path = "/users";
    }

    @When("I send a valid create user payload")
    public void createUser() {
        response = RestAssured.given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .when().body(validRequest)
                .post(path)
                .then().extract().response();
    }

    @Then("response status code should be {int}")
    public void checkResponseStatusCode(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }

    @And("create user response should be valid")
    public void verifyResponse() {
        String username = response.jsonPath().get("username");
        String email = response.jsonPath().get("email");
        String name = response.jsonPath().get("name");
        String id = response.jsonPath().get("id");

        Assert.assertEquals("test-api-user", username);
        Assert.assertEquals("test-api-user@email.com", email);
        Assert.assertEquals("Test Api-User", name);
        Assert.assertNotNull(id);
    }

}
