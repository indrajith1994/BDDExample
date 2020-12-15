package helper;

import APIUtil.payload;
import Pojo.CoopResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TheCoop {

    static String response = null;
    private static FileWriter file;
    static String code;
    private static String directory=System.getProperty("user.dir");

    private String sample=directory+"/src/main/java/testdata"+File.separator+"sample.json";

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


    @Given("make the token call {string}")
    public void makeTheTokenCall(String arg0) {
        RestAssured.baseURI = RestAssured.baseURI + arg0;
    }

    @When("perform post token call")
    public void     performPostTokenCall() throws JsonProcessingException {

//        response = RestAssured.given()
//                .formParam("client_id","RestApi")
//                .formParam("client_secret","75e3ca564180f1d9ed9ccee0f449aeb4")
//                .formParam("grant_type","client_credentials")
//                .post().asString();
//        System.out.println(response);
        CoopResponse cr = given()
                .formParam("client_id","RestApi")
                .formParam("client_secret","75e3ca564180f1d9ed9ccee0f449aeb4")
                .formParam("grant_type","client_credentials")
                .post()
                .then().extract().response().as(CoopResponse.class);
        System.out.println("Access_token: "+cr.getAccess_token());
        System.out.println("expires_in: "+cr.getExpires_in());
        System.out.println("scope: "+cr.getScope());
        System.out.println("token_type: "+cr.getToken_type());
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(cr);
        System.out.println(jsonString);
        System.out.println(directory);


        try {
            FileWriter file = new FileWriter(sample);
            file.write(jsonString);
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        code = cr.getAccess_token();
        System.out.println(code);
//
//        String resp;
//        resp = RestAssured.given()
//                .auth()
//                .oauth2(code)
//                .post("/api/1568/barn-unlock").asString();
//        System.out.println(resp);
    }

    @Then("validate call")
    public void validateCall() {

    }


    @When("perform chickens-feed call")
    public void performChickensFeedCall() {
        String resp = "96893b4fef12a43b4be59ce84303366815241724";
        resp = acccode();
        resp = RestAssured.given()
                .auth()
                .oauth2(resp)
                .post("/api/1568/barn-unlock").asString();
        System.out.println(resp);
    }

    public static String acccode(){
        CoopResponse cr = given()
                .formParam("client_id","RestApi")
                .formParam("client_secret","75e3ca564180f1d9ed9ccee0f449aeb4")
                .formParam("grant_type","client_credentials")
                .post()
                .then().extract().response().as(CoopResponse.class);
        code = cr.getAccess_token();
        System.out.println(code);
        return code;
    }
}
