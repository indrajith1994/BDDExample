package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class WebTables {
    WebDriver driver;
    @FindBy(xpath = "//li[@id='item-3']//span[contains(text(),'Web Tables')]")
    WebElement webtblbox;

    public WebTables(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void webtableheader() throws InterruptedException {
        Thread.sleep(2000);
        webtblbox.click();
        Thread.sleep(100);
        System.out.println("Navigated to Web Table");
        if (driver.findElements(By.xpath("//div[contains(text(),'Web Table')]")).size() > 0) {
            System.out.println("Header is displaying as Web Table");
        } else
            System.out.println("No Header is displayed");
    }

    public void addButton() {
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
    }

    public void registrationForm(String fname, String lname, String e_mail, String age, String salary, String dept) {
        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
        driver.findElement(By.id("userEmail")).sendKeys(e_mail);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(dept);
    }

    public void submitbtn() {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    }

    public void validateNewRecord(String fname, String lname, String e_mail, String age, String salary, String dept) {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='rowgroup']"));
        System.out.println("There are total of " + rows.size() + " rows");
        Iterator<WebElement> itr = rows.iterator();
        System.out.println("Name entered is " + fname);
        Integer count = rows.size();
        for (Integer c = 1; c <= count; c++) {
            if (driver.findElements(By.xpath("//div[@role='rowgroup'][" + c + "]//div[normalize-space()='" + fname + "']")).size() > 0) {
                System.out.println("Firstname available in row number "+c);

                if (driver.findElements(By.xpath("//div[@role='rowgroup'][" + c + "]//div[normalize-space()='" + lname + "']")).size() > 0
                        & driver.findElements(By.xpath("//div[@role='rowgroup'][" + c + "]//div[normalize-space()='" + e_mail + "']")).size() > 0
                        & driver.findElements(By.xpath("//div[@role='rowgroup'][" + c + "]//div[normalize-space()='" + age + "']")).size() > 0
                        & driver.findElements(By.xpath("//div[@role='rowgroup'][" + c + "]//div[normalize-space()='" + salary + "']")).size() > 0
                        & driver.findElements(By.xpath("//div[@role='rowgroup'][" + c + "]//div[normalize-space()='" + salary + "']")).size() > 0) {
                    System.out.println("All other details are available ");
                }
                else
                    System.out.println("Other details are not matching");
            } else
                continue;

        }
    }


    //div[@role='rowgroup']//div[contains(text(),'23')]
}
