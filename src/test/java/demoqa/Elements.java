package demoqa;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    WebDriver driver;

    @FindBy(xpath = "//h5[contains(text(),'Elements')]")
    WebElement elementstab;

    public Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void Elementstab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        elementstab.click();

        System.out.println("Navigated to Elements tab");
    }
}
