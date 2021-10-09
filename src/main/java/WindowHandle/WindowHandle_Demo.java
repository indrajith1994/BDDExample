package WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle_Demo {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        
        WebDriver driver;
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();

// Load the website
//        driver.get("http://www.naukri.com/");

        driver.get("https://demoqa.com/browser-windows");

        // It will return the parent window name as a String
        String parent = driver.getWindowHandle();

        driver.findElement(By.xpath("//button[contains(text(),'New Tab')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'New Window')]")).click();
//        driver.findElement(By.xpath("//button[contains(text(),'New Window Message')]")).click();
        System.out.println(driver.getCurrentUrl());
        Set<String> s = driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();


            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
                Thread.sleep(1000);
                driver.close();
            }

        }
//switch to the parent window
        driver.switchTo().window(parent);
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
