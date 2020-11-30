package helper;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TestJson {

    RequestSpecification httpRequest;
    Response response;
    String key = "d95fdaf076e0412b94f42915202310";

    @Test
    public void getCallRequest() {

        String endPoint_GetUrl = RestAssured.baseURI = "https://api.weatherapi.com/v1/current.json";
        RestAssured.useRelaxedHTTPSValidation();
        response = RestAssured.given()
                .header("Content-Tye", "application/json")
                .queryParam("key",key)
                .queryParam("q","London")
                ////.when().get("https://reqres.in/api/users?page=2").then().extract()
                .when().get(endPoint_GetUrl).then().extract()
                .response();

        int resp = response.getStatusCode();
        System.out.println("Status Code:" + resp);
        Assert.assertEquals(resp, 200);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);

      /*  *//*String responseBodyValue = response.getBody().jsonPath().getString("data.last_name");
        System.out.println("Response Body Location Name : " + responseBodyValue);*//*

        List<String> jsonResponseForData = response.getBody().jsonPath().getList("username");
        System.out.println(jsonResponseForData.get(0));

        for (String usernames: jsonResponseForData) {

            System.out.println(usernames);
        }

        List<Map<String, String>> companies = response.getBody().jsonPath().getList("company");

        System.out.println("Printing Companies Size----->" + companies.size());

        System.out.println(companies.get(2).get("name"));*/

        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + "\nValue: " + header.getValue()+"\n");
        }

        String contentType = response.header("Content-Type");
        System.out.println(contentType);

    }

    @Test
    public void getDetailsJson(){
        JsonPath jsonPath = new JsonPath("{ \"store\": { \"book\": [ { \"category\": \"reference\", \"author\": \"Nigel Rees\", \"title\": \"Sayings of the Century\", \"price\": 8.95 }, { \"category\": \"fiction\", \"author\": \"Evelyn Waugh\", \"title\": \"Sword of Honour\", \"price\": 12.99 }, { \"category\": \"fiction\", \"author\": \"Herman Melville\", \"title\": \"Moby Dick\", \"isbn\": \"0-553-21311-3\", \"price\": 8.99 }, { \"category\": \"fiction\", \"author\": \"J. R. R. Tolkien\", \"title\": \"The Lord of the Rings\", \"isbn\": \"0-395-19395-8\", \"price\": 22.99 } ], \"bicycle\": { \"color\": \"red\", \"price\": 19.95 } } }").using(new JsonPathConfig("UTF-8"));
        List<Integer> books = jsonPath.get("$..book[0,1]");

        List<String> authorDetails = jsonPath.get("$..store.book[?(@.author=='J. R. R. Tolkien')]");

        System.out.println(books);
        System.out.println(authorDetails);
    }

    public static String getPropertyValue(String propKey)
    {

        Properties config = null;
        try {
            config = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\sandeep.gunti\\IdeaProjects\\Selenium_Workshop\\config.properties");

            config.load(ip);
        } catch (Exception e) {


        }

        return config.getProperty(propKey);

    }
}
