package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkbox {
    WebDriver driver;

    @FindBy(xpath = "//li[@id='item-1']//span[contains(text(),'Check Box')]")
    WebElement chkbox;


    public Checkbox(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkboxheader() throws InterruptedException {
        Thread.sleep(2000);
        chkbox.click();
        Thread.sleep(100);
        System.out.println("Navigated to Check Box");
        if(driver.findElements(By.xpath("//div[contains(text(),'Check Box')]")).size()>0){
            System.out.println("Header is displaying as Check Box");
        }
        else
            System.out.println("No Header is displayed");
    }

    public void Navigate(String Val) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'"+Val+"')]/../..//button[@title='Toggle']")).click();
    }

    public void selectExcel() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Excel File.doc')]")).click();
        Thread.sleep(1000);
        if(driver.findElements(By.xpath("//span[contains(text(),'excelFile')]")).size()>0){
            System.out.println("Excel file is selected and got message");
        }
        else
            System.out.println("Not yet selected the excel file");
    }

}
