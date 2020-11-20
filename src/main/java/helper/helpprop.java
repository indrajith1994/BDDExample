package helper;

import java.io.*;
import java.util.Properties;

public class helpprop {
    public static void updateprop(String args, String args1) throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        try (
                OutputStream outputStream = new FileOutputStream("/Users/indrajit/Downloads/BDDExample/config.properties")) {
            properties.setProperty(args, args1);
            properties.store(outputStream, null);


//            PropertiesCache cache = PropertiesCache.getInstance();
//            if(cache.containsKey("country") == false){
//                cache.setProperty("country", "INDIA");
//            }
////Verify property
//            System.out.println(cache.getProperty("country"));
////Write to the file
//            PropertiesCache.getInstance().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getPropertyValue(String propKey)
    {
        Properties config = null;
        try {
            config = new Properties();
            FileInputStream ip = new FileInputStream("/Users/indrajit/Downloads/BDDExample/config.properties");
            config.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config.getProperty(propKey);
    }
}
