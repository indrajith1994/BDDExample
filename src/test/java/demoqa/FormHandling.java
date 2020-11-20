package demoqa;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormHandling {
    WebDriver driver;
    @FindBy(xpath = "//div[contains(text(),'Forms')]/span")
    WebElement formstab;

    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    WebElement practiceforms;


    public FormHandling(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void practiceformtab() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        formstab.click();
        Thread.sleep(500);
        System.out.println("Navigated to Forms tab");
        Thread.sleep(500);
        practiceforms.click();
        Thread.sleep(500);
        System.out.println("Practice forms header available");
    }

    public void fillform(String fname, String lname, String e_mail, String gender, String phnumber, String dob, String subject, String hobbies, String address) throws InterruptedException {
        try {
            driver.findElement(By.id("firstName")).sendKeys(fname);
            Thread.sleep(1000);
            System.out.println("firstName");
            driver.findElement(By.id("lastName")).sendKeys(lname);
            Thread.sleep(1000);
            System.out.println("lastName");
            driver.findElement(By.id("userEmail")).sendKeys(e_mail);
            Thread.sleep(1000);
            System.out.println("userEmail");
            WebElement rdo = driver.findElement(By.id("userEmail"));
            Thread.sleep(200);
            rdo.sendKeys(Keys.TAB,Keys.SPACE);
            Thread.sleep(200);
            System.out.println("Gender selected as "+gender);
            Thread.sleep(2000);
            driver.findElement(By.id("userNumber")).sendKeys(phnumber);
            System.out.println("userNumber");
            Thread.sleep(2000);
            driver.findElement(By.id("subjectsInput")).sendKeys(subject);
            System.out.println("subjectsInput");
            Thread.sleep(2000);
            driver.findElement(By.id("currentAddress")).sendKeys(address);
            System.out.println("currentAddress");
            WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
            uploadElement.sendKeys("/Users/indrajit/Downloads/thumbnail.png");
            Thread.sleep(1500);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,500)");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@id='submit']")).click();
            Thread.sleep(5000);
            if(driver.findElements(By.xpath("//div[contains(text(),'Thanks for submitting the form')]")).size()>0){
                System.out.println("Submitted successfully");
                driver.findElement(By.xpath("//button[@id='closeLargeModal']")).click();
            }
            else
                System.out.println("Form not submitted");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
