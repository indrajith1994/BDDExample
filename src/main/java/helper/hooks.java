//package helper;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class hooks {
//    public WebDriver driver;
//
//
//    @Before
//    public void beforeScenario(){
//        System.out.println("This will run before the Scenario");
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//        driver = new ChromeDriver();
//    }
//
//    @After
//    public void afterScenario(){
//        driver.close();
//        driver.quit();
//        System.out.println("This will run after the Scenario");
//
//    }
//}
