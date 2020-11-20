package helper;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class APITest {

    RequestSpecification httpRequest;
    Response response;

    @Test
    public void getRequest() {

        String endPoint_GetUrl = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";

        response = RestAssured.given()
                .header("Content-Tye", "application/json")
                .when().get(endPoint_GetUrl).then().assertThat().statusCode(200).extract()
                .response();

        /*response = RestAssured.given().header("Content-Tye","application/json").when()
                .get(endPoint_GetUrl).then().extract().response();*/


       long timeTaken = response.getTimeIn(TimeUnit.MILLISECONDS);
       System.out.print("Time taken to get the response" + timeTaken + "seconds" );

        String responseBody = response.getBody().asString();
        System.out.println("Success Message.. " + responseBody);

        String responseBodyValue = response.getBody().jsonPath().getString("status");
        System.out.println("Success Message.. " + responseBodyValue);

        List<String> li = getListFromJsonPath(responseBody,"$.data[*]");
        System.out.println("Response Body Success Message: " + li);


        List<Map<String, String>> dataList = response.getBody().jsonPath().getList("data");
        System.out.println("Printing the data list size..." +dataList.size());
        for(Map<String, String> map: dataList){
            System.out.println("Printing the id........" +map.get("id"));
            System.out.println("Printing the employee salary....." + map.get("employee_salary"));
        }

        Headers allHeaders = response.headers();

        for (Header header : allHeaders) {
            System.out.println("------------------Printing Headers-----------------");
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        String contentType = response.header("Content-Type");
        System.out.println(contentType);

    }

    @Test
    public void postRequest() {

        String endPoint_postUrl = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
        response = RestAssured.given()
                .header("Content-Tye", "application/json")
                .queryParam("key","467473356343")
                .queryParam("q","London")

                .when().body("{\n" +
                        "    \"name\": \"Sandeep\",\n" +
                        "    \"job\": \"POD LEAD\"\n" +
                        "}").post(endPoint_postUrl).then().extract()
                .response();
        int resp = response.getStatusCode();
        System.out.println("Status Code:" + resp);
        Assert.assertEquals(resp, 201);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);

        String responseBodyValue = response.jsonPath().getString("status");
        System.out.println("Response Body Success Message: " + responseBodyValue);

    }

    @Test
    public void putRequest() {

        String endPoint_PutUrl = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/update/21";

        response = RestAssured.given()
                .header("Content-Tye", "application/json")
                .when().body("{\n" +
                        "    \"name\": \"Sandeep\",\n" +
                        "    \"job\": \"POD LEAD\"\n" +
                        "}").post(endPoint_PutUrl).then().extract()
                .response();

        int resp = response.getStatusCode();
        System.out.println("Status Code:" + resp);
        Assert.assertEquals(resp, 200);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);

        String responseBodyValue = response.jsonPath().getString("status");
        System.out.println("Response Body Success Message: " + responseBodyValue);

    }


    @Test
    public void deleteRequest() {

        String endPoint_DeleteUrl = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/delete/2";

        response = RestAssured.given()
                .header("Content-Tye", "application/json")
                .queryParam("key","sdsd")

                .when().delete(endPoint_DeleteUrl).then().assertThat().statusCode(200).extract()
                .response();

        int resp = response.getStatusCode();
        System.out.println("Status Code:" + resp);
        Assert.assertEquals(resp, 204);


        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);

        String responseBodyValue = response.getBody().jsonPath().getString("status");
        System.out.println("Response Body Success Message: " + responseBodyValue);



    }

    @Test
    public void validateJSON(){

       // $..store.book[?(@.author=='sandeep')]


        String jsonPayload = "{ \"store\": { \"book\": [ { \"category\": \"reference\", \"author\": \"Nigel Rees\", \"title\": \"Sayings of the Century\", \"price\": 8.95 }, { \"category\": \"fiction\", \"author\": \"Evelyn Waugh\", \"title\": \"Sword of Honour\", \"price\": 12.99 }, { \"category\": \"fiction\", \"author\": \"Herman Melville\", \"title\": \"Moby Dick\", \"isbn\": \"0-553-21311-3\", \"price\": 8.99 }, { \"category\": \"fiction\", \"author\": \"J. R. R. Tolkien\", \"title\": \"The Lord of the Rings\", \"isbn\": \"0-395-19395-8\", \"price\": 22.99 } ], \"bicycle\": { \"color\": \"red\", \"price\": 19.95 } }, \"expensive\": 10 }";


        List<String> li = getListFromJsonPath(jsonPayload,getPropertyValue("valuexpath"));

        //List<String> li1 = getListFromJsonPath(jsonPayload,"$..store.book[?(@.author=='J. R. R. Tolkien')]");

        System.out.println("Printing the categories.."  + li);
       // System.out.println(li1);


       String jsonPayload1 ="{ \"category\": \"fiction\", \"author\": \"J. R. R. Tolkien\", \"title\": \"The Lord of the Rings\", \"isbn\": \"0-395-19395-8\", \"price\": 22.99 }";
        String getPrice = getStringFromJsonPath(jsonPayload1,"$..price");
        System.out.println(getPrice);

    }

    public static List<String> getListFromJsonPath(String json,String xpath){

        try{

            List<String> outputList = new ArrayList<String>();
            Collection<? extends String> array = JsonPath.read(json,xpath);
            if(array.size()>0){
                for(Object obj:array){
                    outputList.add(obj.toString());

                }
            }
            return outputList;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static String getStringFromJsonPath(String json,String xpath){
        try{

            return JsonPath.read(json,xpath)+"";
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }



    public Response getReq(String url) {
        try {
            response = httpRequest.get(new URI(url));
            return response;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response postReq(String url, String jsonBody) {
        httpRequest.body(jsonBody);
        try {
            Response response = httpRequest.post(new URI(url));
            return response;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test
    public void getCallRequest() {

        //String endPoint_GetUrl = RestAssured.baseURI = "https://api.weatherapi.com/v1/current.json?key=7938cce69907408eb86103122201910&q=London";
        RestAssured.useRelaxedHTTPSValidation();
        response = RestAssured.given()
                .header("Content-Tye", "application/json")
                //.queryParam("key","7938cce69907408eb86103122201910")
                .queryParam("page","2")
                //.queryParam("q","London")
                .when().get("https://reqres.in/api/users?page=2").then().extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);

        String responseBodyValue = response.getBody().jsonPath().getString("data.last_name");
        System.out.println("Response Body Location Name : " + responseBodyValue);


        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }

        String contentType = response.header("Content-Type");
        System.out.println(contentType);

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
