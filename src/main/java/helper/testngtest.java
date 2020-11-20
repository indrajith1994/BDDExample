package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;

public class testngtest {
    static File folder;
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        folder = new File("/Users/indrajit/Downloads/BDDExample/src/main/java/helper/download");
        folder.mkdir();

        //final String path = Paths.get("Download").toAbsolutePath().toString();
        HashMap<String, Object> prefs = new HashMap<String ,Object>();
        prefs.put("profile.default_content_settings.popups",0);
        prefs.put("download.default_directory", folder.getAbsolutePath());

        ChromeOptions options =new ChromeOptions();
        options.setExperimentalOption("prefs",prefs);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);


        //click on Excel
        driver.get("https://rubygems.org/gems/selenium-webdriver");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("download"));
        element.click();
        Thread.sleep(5000);

        driver.quit();
//        folder.delete();
    }
}
