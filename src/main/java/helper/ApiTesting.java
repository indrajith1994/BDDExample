package helper;

import APIUtil.payload;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.json.JSONObject;
import org.testng.Assert;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class ApiTesting {

    static RequestSpecification httpRequest = null;
    static Response response = null;
    static String endPoint_URL;

    @Given("I have an endpoint url {string}")
    public void iHaveAnEndpointUrl(String arg0) {
        endPoint_URL = RestAssured.baseURI = arg0;
//        System.out.println(httpRequest);
//        System.out.println(response);
//        System.out.println(endPoint_URL);
    }

    @When("I hit the get request")
    public void iHitTheGetRequest() {
        response = RestAssured
                .given().header("Content-Type", "application/json")
                .when().get(endPoint_URL)
                .then().extract().response();
//        System.out.println(response);
    }

    @Then("I should validate the response code and response body after Get request")
    public void iShouldValidateTheResponseCodeAndResponseBodyAfterGetRequest() {
        System.out.println(response.getStatusCode());
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        System.out.println(response.getBody().jsonPath().getString("status"));

        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");

//        Map<String, Object> retMap = new HashMap<String, Object>();
//        System.out.println(retMap.size());
//        System.out.println(retMap);


//        List<Map<String,String>> dataList = response.getBody().jsonPath().getList("data");
//        System.out.println(dataList.size());
//        Assert.assertEquals(response.getStatusCode(),200);
    }


    @When("I hit the post request")
    public void iHitThePostRequest() {
        response = RestAssured
                .given()
                .when().body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").post(endPoint_URL)
                .then().extract().response();
    }


    @Then("I should validate the response code and success message after Post request")
    public void iShouldValidateTheResponseCodeAndSuccessMessageAfterPostRequest() {
        System.out.println(response.getStatusCode());
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
//        System.out.println(response.getBody().jsonPath().getString("id"));
//        System.out.println(response.getBody().jsonPath().getString("name"));
//        System.out.println(response.getBody().jsonPath().getString("job"));
    }

    @When("I hit the put request")
    public void iHitThePutRequest() {
        response = RestAssured
                .given().header("Content-Type", "application/json")
                .when().body("{\n" +
                        "\"employee_name\": \"New fg Kelly\",\n" +
                        "\"employee_salary\": 123456\n" +
                        "}").put(endPoint_URL)
                .then().extract().response();
    }

    @Then("I should validate the response code and success message after Put request")
    public void iShouldValidateTheResponseCodeAndSuccessMessageAfterPutRequest() {
        System.out.println(response.getStatusCode());
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
    }

    @Then("I should validate the response code and print all the employee names and salary from the data set")
    public void iShouldValidateTheResponseCodeAndPrintAllTheEmployeeNamesAndSalaryFromTheDataSet() {
        List<Map<String, String>> dataList = response.getBody().jsonPath().getList("data");
        System.out.println(dataList.size());
        for (Map<String, String> map : dataList) {
            System.out.println("Printing the \nemployee name - " + map.get("employee_name") + "\nSalary - " + map.get("employee_salary"));
        }

    }

    @Then("I should validate all the headers from the response")
    public void iShouldValidateAllTheHeadersFromTheResponse() {
        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + "\nValue: " + header.getValue() + "\n");
        }
    }


    @When("I hit the get request {string}")
    public void iHitTheGetRequest(String arg0) {
        response = RestAssured
                .given().param("page", arg0)
                .when().get(endPoint_URL)
                .then().assertThat().statusCode(200).extract().response();
//        System.out.println(response);
    }

    @Then("I should validate the response code and print all the email ids from the data set")
    public void iShouldValidateTheResponseCodeAndPrintAllTheEmailIdsFromTheDataSet() {
        List<Map<String, String>> dataList = response.getBody().jsonPath().getList("data");
        System.out.println(dataList.size());
        for (Map<String, String> map : dataList) {
            System.out.println("employee last name - " + map.get("last_name") + "\nemail id - " + map.get("email"));
        }
    }

    @Then("I should validate last name associated with email id from data set")
    public void iShouldValidateLastNameAssociatedWithEmailIdFromDataSet() {
        List<Map<String, String>> dataList = response.getBody().jsonPath().getList("data");
        System.out.println(dataList.size());
        for (Map<String, String> map : dataList) {
            String email = map.get("email");
            String lastname = map.get("last_name");
//            System.out.println(email + lastname);
            if (email.contains(lastname.toLowerCase())) {
                System.out.println("first name - " + map.get("first_name") + " contains email and last name matched");
            } else
                System.out.println("email and last name not matched");
        }
    }

    @When("I hit the post request with header")
    public void iHitThePostRequestWithHeader() {
        response = RestAssured
                .given().header("Content-Type", "application/json").header("accept", "application/json")
                .when().body("{\n" +
                        "    \"id\": 42,\n" +
                        "    \"petId\": 3234,\n" +
                        "    \"quantity\": 1,\n" +
                        "    \"shipDate\": \"2020-10-27T05:33:08.673Z\",\n" +
                        "    \"status\": \"placed\",\n" +
                        "    \"complete\": true\n" +
                        "  }")
                .post(endPoint_URL)
                .then().assertThat().statusCode(200).extract().response();
    }

    @Then("Body has below given json details")
    public void bodyHasBelowGivenJsonDetails(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            if (response.getBody().jsonPath().getString(list.get(num).get("Key")).equalsIgnoreCase(list.get(num).get("Value"))) {
                System.out.println("Response got " + response.getBody().jsonPath().getString(list.get(num).get("Key")) + " Post request sent is " + list.get(num).get("Value") + " Matched");
            } else
                System.out.println("not Matched");

        }
    }


    @Then("Validate from Get request body {string}")
    public void validateFromGetRequestBody(String arg0) {
        endPoint_URL = RestAssured.baseURI = arg0;
        response = RestAssured
                .given()
                .when().get(endPoint_URL)
                .then().extract().response();
    }

    @When("I hit the delete request")
    public void iHitTheDeleteRequest() {
        response = RestAssured
                .given()
                .when().delete(endPoint_URL)
                .then().assertThat().statusCode(200).extract().response();
    }

    @Then("I should validate the response code after Delete request")
    public void iShouldValidateTheResponseCodeAfterDeleteRequest() {
        System.out.println(response.getStatusCode());
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
    }

    @When("I hit the post request with array format")
    public void iHitThePostRequestWithArrayFormat() {
        response = RestAssured
                .given().header("Content-Type", "application/json").header("accept", "application/json")
                .when().body("[{\n" +
                        "\t\"id\": 1234,\n" +
                        "\t\"username\": \"Array\",\n" +
                        "\t\"firstName\": \"Userone\",\n" +
                        "\t\"lastName\": \"Lastname\",\n" +
                        "\t\"email\": \"testemail@test.com\",\n" +
                        "\t\"password\": \"qwerty\",\n" +
                        "\t\"phone\": \"1234567\",\n" +
                        "\t\"userStatus\": 0\n" +
                        "}]")
                .post(endPoint_URL)
                .then().assertThat().statusCode(200).extract().response();
    }

    @When("I hit the post request with List format")
    public void iHitThePostRequestWithListFormat() {
        response = RestAssured
                .given().header("Content-Type", "application/json").header("accept", "application/json")
                .when().body("[{\n" +
                        "\t\"id\": 2345,\n" +
                        "\t\"username\": \"List\",\n" +
                        "\t\"firstName\": \"Listname\",\n" +
                        "\t\"lastName\": \"Lastname\",\n" +
                        "\t\"email\": \"test@test.com\",\n" +
                        "\t\"password\": \"asdfgh\",\n" +
                        "\t\"phone\": \"12345\",\n" +
                        "\t\"userStatus\": 0\n" +
                        "}]")
                .post(endPoint_URL)
                .then().assertThat().statusCode(200).extract().response();
    }

    @Then("I should validate the response code and response body has below given json details")
    public void iShouldValidateTheResponseCodeAndResponseBodyHasBelowGivenJsonDetails(DataTable table) {
        System.out.println(response.getStatusCode());
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);


        List<Map<String, String>> list = table.asMaps();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            if (response.getBody().jsonPath().getString(list.get(num).get("Key")).equalsIgnoreCase(list.get(num).get("Value"))) {
                System.out.println("Response got " + response.getBody().jsonPath().getString(list.get(num).get("Key")) + " Post request sent is " + list.get(num).get("Value") + " - " + list.get(num).get("Key") + " Matched");
            } else
                System.out.println("not Matched");

        }
    }

    @When("I hit the put request update user")
    public void iHitThePutRequestUpdateUser() {
        response = RestAssured
                .given().header("Content-Type", "application/json")
                .when().body("{\n" +
                        "\t\"id\": 2345,\n" +
                        "\t\"username\": \"ListChanges\",\n" +
                        "\t\"firstName\": \"ListName\",\n" +
                        "\t\"lastName\": \"LastName\",\n" +
                        "\t\"email\": \"new@test.com\",\n" +
                        "\t\"password\": \"asdfgh\",\n" +
                        "\t\"phone\": \"67890\",\n" +
                        "\t\"userStatus\": 0\n" +
                        "}").put(endPoint_URL)
                .then().extract().response();
    }


    @When("I hit the get request basic auth")
    public void iHitTheGetRequestBasicAuth() {
        response = RestAssured
                .given().auth().preemptive().basic("postman", "password")
                .when().get(endPoint_URL)
                .then().extract().response();
    }

    @When("I hit the get request Digest Auth")
    public void iHitTheGetRequestDigestAuth() {
        response = RestAssured
                .given().auth().digest("postman", "password")
//    Authorization    Digest username="postman", realm="Users", nonce="ni1LiL0O37PRRhofWdCLmwFsnEtH1lew", uri="/digest-auth", response="254679099562cf07df9b6f5d8d15db44", opaque=""
                .when().get(endPoint_URL)
                .then().extract().response();
    }

    @When("I hit the get request Hawk Auth")
    public void iHitTheGetRequestHawkAuth() {
        response = RestAssured
                .given().auth().digest("postman", "password")
//    Authorization    Digest username="postman", realm="Users", nonce="ni1LiL0O37PRRhofWdCLmwFsnEtH1lew", uri="/digest-auth", response="254679099562cf07df9b6f5d8d15db44", opaque=""
                .when().get(endPoint_URL)
                .then().extract().response();
    }

    @When("I hit the get request auth")
    public void iHitTheGetRequestAuth() {
        response = RestAssured.given()
                .auth().oauth2("a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e")
                .when().get(endPoint_URL)
                .then().extract().response();
    }

    @When("I hit the post request auth")
    public void iHitThePostRequestAuth(DataTable table) {
        response = RestAssured.given().header("Authorization", "Bearer a3d05172f0b2cc6e733c0edd0f29e83dc70515b1a00628ec18ed3af0af88e35e")
                .header("Content-Type", "application/json")
                .when().body("{\n" +
                        "\t\"name\": \"Testpage\",\n" +
                        "\t\"email\": \"testpage@git.com\",\n" +
                        "\t\"gender\": \"Male\",\n" +
                        "\t\"status\": \"Inactive\"\n" +
                        "}").post(endPoint_URL)
                .then().extract().response();
    }


    @When("I hit the get request auth param")
    public void iHitTheGetRequestAuthParam(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }
        response = RestAssured.given()
                .headers(headerMap)
                .when().get(endPoint_URL)
                .then().extract().response();
    }

    @When("I hit the post request auth param")
    public void iHitThePostRequestAuthParam(DataTable table) {
        String body = "{\n" +
                "\t\"name\": \"Testqwpg\",\n" +
                "\t\"email\": \"testqwpg@git.com\",\n" +
                "\t\"gender\": \"Male\",\n" +
                "\t\"status\": \"Inactive\"\n" +
                "}";

        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }
        response = RestAssured.given().headers(headerMap)
                .when().body(body).post(endPoint_URL)
                .then().extract().response();
    }

    @And("Validate with get request")
    public void vaidateWithGetRequest() {
        String responseBody = response.getBody().asString();
        String code =response.getBody().jsonPath().getString("code");
        String id =response.getBody().jsonPath().getString("data.id");
        String name =response.getBody().jsonPath().getString("data.name");
        String email =response.getBody().jsonPath().getString("data.email");
        String gender =response.getBody().jsonPath().getString("data.gender");
        String status =response.getBody().jsonPath().getString("data.status");
        System.out.println(code);
        System.out.println(id);
        System.out.println(name);
        System.out.println(email);
        System.out.println(gender);
        System.out.println(status);
        String userid = "?id="+id+"";
        System.out.println("User id created is "+userid);
        response = RestAssured.given()
                .when().get(endPoint_URL+userid)
                .then().extract().response();
        System.out.println(response.getStatusCode());
        String responsegetBody = response.getBody().asString();
        System.out.println(responsegetBody);
    }



//    @When("I have {int} books here")
//    public void iHaveBooksHere(int arg0) {
//    }
    @When("^I have (\\d+) books? here$")
    public void i_have_book_here(int arg1)  {


    }

    @When("I have {int} book here")
    public void iHaveBookHere(int arg0) {
    }
//    @When("I have {int} books? here")
//    public void iHaveBookHerenew(int arg0) {
//    }

    @When("^I have notes? here$")
    public void iHaveNoteHere() {


    }


    @Given("Hitting endpoint url {string}")
    public void hittingEndpointUrl(String arg0) {
        RestAssured.baseURI = arg0;
    }
    static String response1 = "";
    @When("Making post request")
    public void makingGetRequest() {
        response1 = RestAssured.
                given().log().all().body(payload.createUser()).
                when().post("/api/users").
                then().log().all().assertThat().statusCode(201).extract().response().asString();
    }

    @Then("Validate post Response")
    public void validateGetResponse() {
       System.out.println(response1);
        JsonPath js = new JsonPath(response1);
        String id = js.getString("id");
        String timeStamp = js.getString("createdAt");
        System.out.println(id);
        System.out.println(timeStamp);
    }
}
