package helper;

import APIUtil.payload;
import Pojo.goRestpojo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class goRest  {
    static String response = null;
    static String id = "1452";

    @Given("Hit endpoint url {string}")
    public void hitEndpointUrl(String arg0) {
        RestAssured.baseURI = arg0;
    }

    @When("Hitting the Get request auth param")
    public void hittingTheGetRequestAuthParam(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }
        response = given().log().all().headers(headerMap).
                when().get("/public-api/users").
                then().extract().response().asString();
//        goRestpojo gr = given().headers(headerMap).expect().when().get("/public-api/users/" + id).as(goRestpojo.class);
        goRestpojo gr = given().log().all().headers(headerMap).
                when().get("/public-api/users").
                then().extract().response().as(goRestpojo.class);
        System.out.println(gr.getCode());
        System.out.println(gr.getMeta().getPagination().getLimit());
        System.out.println(gr.getMeta().getPagination().getPage());
        System.out.println(gr.getMeta().getPagination().getPages());
        System.out.println(gr.getMeta().getPagination().getTotal());
        System.out.println(gr.getData().get(1).getId());
        System.out.println(gr.getData().get(1).getCreated_at());
        System.out.println(gr.getData().get(1).getEmail());
        System.out.println(gr.getData().get(1).getGender());
        System.out.println(gr.getData().get(1).getStatus());
        System.out.println(gr.getData().get(1).getUpdated_at());
    }

    @When("Hitting the Get request auth param retrieve")
    public void hittingTheGetRequestAuthParamRetrieve(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }
        response = given().log().all().headers(headerMap).
                when().get("/public-api/users/" + id).
                then().extract().response().asString();

    }

    @Then("Validate Get response")
    public void validateGetResponse() {
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String code = js.getString("code");
        System.out.println(code);
    }

    @When("Hitting the Post request auth param")
    public void hittingThePostRequestAuthParam(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }
        response = given().log().all().headers(headerMap).body(payload.newUser()).
                when().post("public-api/users").
                then().log().all().extract().response().asString();
//                then().log().all().assertThat().statusCode(200).extract().response().asString();
    }

    @Then("Validate Post response")
    public void validatePostResponse() {
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String code = js.getString("code");
        id = js.getString("data.id");
        System.out.println(code);
        System.out.println(id);

    }

    @When("Hitting the Put request auth param")
    public void hittingThePutRequestAuthParam(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }
        response = given().log().all().headers(headerMap).body(payload.updateUser()).
                when().put("public-api/users/" + id).
                then().log().all().extract().response().asString();
    }

    @Then("Validate Put response")
    public void validatePutResponse() {
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String code = js.getString("code");
        id = js.getString("data.id");
        System.out.println(code);
        System.out.println(id);

    }

    @When("Hitting the Delete request auth param")
    public void hittingTheDeleteRequestAuthParam(DataTable table) {
        List<Map<String, String>> list = table.asMaps();
        Map<String, String> headerMap = new HashMap<String, String>();
        int count = list.size();
        int num;
        for (num = 0; num < count; num++) {
            headerMap.put(list.get(num).get("Key"), list.get(num).get("Value"));
        }

        response = given().log().all().headers(headerMap).body(payload.newUser()).
                when().delete("public-api/users/" + id).
                then().log().all().extract().response().asString();
    }

    @Then("Validate Delete response")
    public void validateDeleteResponse() {
        System.out.println(response);
    }


}
