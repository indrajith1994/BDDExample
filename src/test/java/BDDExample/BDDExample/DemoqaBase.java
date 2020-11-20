package BDDExample.BDDExample;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class DemoqaBase {

    public WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public static String getPropertyValue(String propKey)
    {

        Properties config = null;
        try {
            config = new Properties();
            FileInputStream ip = new FileInputStream("/Users/indrajit/Downloads/BDDExample/config.properties");

            config.load(ip);
        } catch (Exception e) {

        }

        return config.getProperty(propKey);

    }

}


