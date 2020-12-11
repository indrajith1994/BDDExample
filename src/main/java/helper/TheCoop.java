package helper;

import APIUtil.payload;
import Pojo.CoopResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TheCoop {

    static String response = null;

    @Given("The page URL is {string}")
    public void thePageURLIs(String arg0) {
        RestAssured.baseURI = arg0;
    }

    @Given("The barn unlock url is {string}")
    public void theBarnUnlockUrlIs(String arg0) {
        RestAssured.baseURI = RestAssured.baseURI + arg0;
    }

    @When("Perform post operation")
    public void performPostOperation(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }
        response = given().log().all().headers(headerMap).
                when().post().
                then().log().all().extract().response().asString();
        CoopResponse co = given().log().all().headers(headerMap).
                when().post().then().log().all().extract().response().as(CoopResponse.class);
        System.out.println(co.getAction());
        System.out.println(co.getData());
        System.out.println(co.getMessage());
        System.out.println(co.getSuccess());

    }

    @Then("Validate the response of post")
    public void validateTheResponseOfPost() {
        System.out.println(response);
    }


}
