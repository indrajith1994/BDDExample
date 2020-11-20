package APIUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Map;

public class SampleGetPostTest {

    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;


    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {
        System.out.println("Background Given ");
        RestAssured.baseURI = BASE_URL;
        System.out.println(RestAssured.baseURI);

        RequestSpecification request = RestAssured.given();
        System.out.println(request);

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");
        System.out.println(response);

        String jsonString = response.asString();
        System.out.println(jsonString);

        token = JsonPath.from(jsonString).get("token");
        System.out.println(token);
    }

    @Given("A list of books are available")
    public void aListOfBooksAreAvailable() {
        System.out.println("Scenario Given ");
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");

        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

        bookId = books.get(0).get("isbn");
    }

    @When("I add a book to my reading list")
    public void iAddABookToMyReadingList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                .post("/BookStore/v1/Books");
    }

    @Then("the book is added")
    public void theBookIsAdded() {

        Assert.assertEquals(401, response.getStatusCode());
    }

    @When("I remove a book from my reading list")
    public void iRemoveABookFromMyReadingList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
                .delete("/BookStore/v1/Book");


    }

    @Then("the book is removed")
    public void theBookIsRemoved() {
        Assert.assertEquals(401, response.getStatusCode());

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(401, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());
    }

    @Test
    public void RegistrationSuccessful()
    {
        RestAssured.baseURI ="https://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Sandeep"); // Cast
        requestParams.put("LastName", "Gunti");
        requestParams.put("UserName", "sdimpleuser2dd2011");
        requestParams.put("Password", "password1");

        requestParams.put("Email",  "sample2ee26d9@gmail.com");
        request.body(requestParams.toString());
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, "201");
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
    }

    @Test
    public void GetWeatherDetails()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, "/Hyderabad");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

    }


}
