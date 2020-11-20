package selenium;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import org.junit.Test;

import java.util.List;

public class jsontest {
    @Test
    public void getDetailsJson(){
        JsonPath jsonPath = new JsonPath("{ \"store\": { \"book\": [ { \"category\": \"reference\", \"author\": \"Nigel Rees\", \"title\": \"Sayings of the Century\", \"price\": 8.95 }, { \"category\": \"fiction\", \"author\": \"Evelyn Waugh\", \"title\": \"Sword of Honour\", \"price\": 12.99 }, { \"category\": \"fiction\", \"author\": \"Herman Melville\", \"title\": \"Moby Dick\", \"isbn\": \"0-553-21311-3\", \"price\": 8.99 }, { \"category\": \"fiction\", \"author\": \"J. R. R. Tolkien\", \"title\": \"The Lord of the Rings\", \"isbn\": \"0-395-19395-8\", \"price\": 22.99 } ], \"bicycle\": { \"color\": \"red\", \"price\": 19.95 } } }").using(new JsonPathConfig("UTF-8"));
        List<Integer> books = jsonPath.get("$..book[0,1]");

        List<String> authorDetails = jsonPath.get("$..store.book[?(@.author=='J. R. R. Tolkien')]");

        System.out.println(books);
        System.out.println(authorDetails);
    }
}
