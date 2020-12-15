package helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TwitterAPI {
    static String Resp = null;
    @Then("Validate the response of tweet")
    public void validateTheResponseOfTweet() {
    }

    @Given("Opening twitter page {string}")
    public void openingTwitterPage(String arg0) {
        RestAssured.baseURI = arg0;
    }

    @When("Making tweet post call")
    public void makingTweetPostCall() {

        Response response = RestAssured.given().log().all()
                .auth()
                .oauth("nkIV6H1zxOBPX1aavsfg9iUsg",
                        "wU7RKOb3nsyUBtOiSXklvKtLIjNgTDVp39DU5BtjckplW7F1HO",
                        "154510231-QYsANcE0s5S9fyD0KUhJckbp5pxvWGTrB2ccyo0p",
                        "27wmwrSOacrKKCnZPTDr4mXZ0rbNcYs80mLGoA0y59rnJ")
//                .auth()
//                .oauth2("AAAAAAAAAAAAAAAAAAAAAEuaKgEAAAAA06lYKzQghhHCOVovtOsorKOAzW0%3DIydnz8JcluR6rBh0FTEurVfxWP0llotpsGvShiN5WvVOQIcPzk")
                .formParam("status","tweet via API")
                .post();
        System.out.println(response.getStatusCode());
    }
}
