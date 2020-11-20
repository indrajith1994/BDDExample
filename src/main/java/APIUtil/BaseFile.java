package APIUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseFile {
//    WebElement driver;

   // @Before
   // public void setUp() throws InterruptedException {
   //     System.out.println("Before");
   //     System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
   //     driver = new ChromeDriver();
   //     Thread.sleep(5000);

   // }

   // @After
   // public void tearDown() {
   //     System.out.println("After");
   //     driver.close();
   //     driver.quit();
   // }

//    public WebDriver driver;
//
//    @BeforeTest
//    public void setUp() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//
//        driver = new ChromeDriver();
//        Thread.sleep(5000);
//        driver.get("https://adactinhotelapp.com/");
//        driver.manage().window().maximize();
//    }
//
//    @AfterTest
//    public void tearDown() {
//        driver.close();
//        driver.quit();
//    }



    public static String getPropertyValue(String propKey) {

        Properties confg = null;
        try {
            confg = new Properties();
            FileInputStream ip = new FileInputStream("/Users/indrajit/Downloads/BDDExample/confg.properties");
            confg.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return confg.getProperty(propKey);

    }

}
