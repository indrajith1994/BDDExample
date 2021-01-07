package Twitter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class posttweet {
    Response response;

    @Test
    public void getRequest() {
//        String endPoint_GetUrl = RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/update.json?status=POSTMAN new Tweet";
         RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
//        response = RestAssured.given()
//                .param("oauth_consumer_key","tKN75JF7aYGv7OUA052xOSBu5")
//                .param("oauth_consumer_secret","B9Xl6Y98cFGcYDDULoEmon7Oal5v343eLdz8zFhv3VRWgMDXzo")
//                .param("oauth_token","154510231-SImW0NqCGGyybRofUbGJAkUxsQBl8Tm1ofvyjzbq")
//                .param("oauth_token_secret","e5w1thAHt3H8S1X1wB4ggAjKI2B4UCiOinQ47FHDWgPlU")
//                .when().post("/update.json?status=POSTMAN new Tweet").then().extract()
//                .response();
        response = RestAssured.given()
                .header("Authorization","OAuth oauth_consumer_key=\"tKN75JF7aYGv7OUA052xOSBu5\",oauth_token=\"154510231-SImW0NqCGGyybRofUbGJAkUxsQBl8Tm1ofvyjzbq\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1609839976\",oauth_nonce=\"MLRoyT\",oauth_version=\"1.0\",oauth_signature=\"%2FgqsX01gv21%2Bq8fHfIpoeI%2F7mMY%3D\"")
                .when().post("/update.json?status=POSTMAN Tweet").then().extract()
                .response();
        String Resp = response.asString();
        System.out.println(Resp);
    }
}
