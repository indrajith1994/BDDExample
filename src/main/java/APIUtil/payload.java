package APIUtil;

public class payload {
    public static String createUser(){
        return "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }
    public static String newUser(){
        return "{\n" +
                "\t\"name\": \"Teasng\",\n" +
                "\t\"email\": \"teasmg@test.com\",\n" +
                "\t\"gender\": \"Male\",\n" +
                "\t\"status\": \"Inactive\"\n" +
                "}";
    }
    public static String updateUser(){
        return "{\n" +
                "\t\"name\": \"updateTeasng\",\n" +
                "\t\"email\": \"udteasmg@test.com\",\n" +
                "\t\"gender\": \"Male\",\n" +
                "\t\"status\": \"Inactive\"\n" +
                "}";
    }
}
