package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class Links {
    WebDriver driver;

    @FindBy(xpath = "//li[@id=\"item-5\"]//span[contains(text(),'Links')]")
    WebElement linkstab;

    public Links(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void Linkstab() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        linkstab.click();
        System.out.println("Navigated to Links tab");
    }

    public void linkscount() throws InterruptedException {

        List<WebElement> links = driver.findElements(By.xpath("//div[@id='linkWrapper']//a"));
        System.out.println("There are total of "+links.size());
        Iterator<WebElement> itr = links.iterator();
        System.out.println("Links Available are displayed below");
        while(itr.hasNext()) {
            System.out.println(itr.next().getText());
        }
        Thread.sleep(1000);

    }
}
