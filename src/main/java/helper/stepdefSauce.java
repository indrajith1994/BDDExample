package helper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepdefSauce {
    static WebDriver driver;
    static String proddesc = null;
    static String prodprice = null;
    static String prod = null;




    @Given("Navigate to shopping url")
    public void navigateToShoppingUrl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

//    @When("Get Username from homepage")
//    public void getUsernameFromHomepage() throws InterruptedException {
//        Thread.sleep(3000);
//        System.out.println("getUsernameFromHomepage");
////        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        String usename = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();
//        System.out.println(usename);
//        System.out.println("user name got first");
//        System.out.println("user name got next");
//        String usrid[] = usename.split("\\r?\\n");
//        for (int i=0; i<usrid.length; i++) {
//            System.out.println(usrid[i]);
//        }
//        driver.findElement(By.id("user-name")).sendKeys(usrid[1]);
//        System.out.println("user name seperated");
//    }


//    @When("Get Password from homepage")
//    public void getPasswordFromHomepage() throws InterruptedException {
//        Thread.sleep(1000);
//        String pwd = driver.findElement(By.xpath("//div[@class='login_password']")).getText();
//        String passwd[] = pwd.split("\\r?\\n");
//        for (int i=0; i<passwd.length; i++) {
//            System.out.println(passwd[i]);
//        }
//        driver.findElement(By.id("password")).sendKeys(passwd[1]);
//        System.out.println("getPasswordFromHomepage");
//    }

    @When("Click Login button")
    public void clickLoginButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        System.out.println("clickLoginButton");
    }

    @Then("Validate user is in home page")
    public void validateUserIsInHomePage() throws InterruptedException {
        Thread.sleep(3000);
        if (driver.findElements(By.xpath("//div[contains(text(),'Products')]")).size() > 0) {
            System.out.println("Reached product page");
        } else
            System.out.println("Product page not available");
    }

    @When("Search for {string} product")
    public void searchForProduct(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        if (driver.findElements(By.xpath("//div[contains(text(),'" + arg0 + "')]")).size() > 0) {
            System.out.println("Search product " + arg0 + " available");
            prod = arg0;
            proddesc = driver.findElement(By.xpath("//div[contains(text(),'" + arg0 + "')]/../../..//div[@class='inventory_item_desc']")).getText();
            prodprice = driver.findElement(By.xpath("//div[contains(text(),'" + arg0 + "')]/../../..//div[@class='inventory_item_price']")).getText();
            prodprice = prodprice.replaceAll("$", "");
            driver.findElement(By.xpath("//div[contains(text(),'" + arg0 + "')]/../../..//button")).click();

            System.out.println("Product added to cart");
        } else
            System.out.println("Product not available");
    }

    @When("Get Username and Password from homepage and enter")
    public void getUsernameAndPasswordFromHomepageAndEnter() throws InterruptedException {
        Thread.sleep(2000);
        String usename = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();
        String usrid[] = usename.split("\\r?\\n");
        driver.findElement(By.id("user-name")).sendKeys(usrid[1]);

        Thread.sleep(2000);
        String pwd = driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String passwd[] = pwd.split("\\r?\\n");
        driver.findElement(By.id("password")).sendKeys(passwd[1]);
        System.out.println("Username and password entered");
    }

    @When("Click on Cart icon")
    public void clickOnCartIcon() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
        Thread.sleep(2000);
    }

    @Then("Verify product details")
    public void verifyProductDetails() throws InterruptedException {
        Thread.sleep(4000);
        if (driver.findElements(By.xpath("//div[contains(text(),'" + prod + "')]")).size() > 0) {
            String valdesc = driver.findElement(By.xpath("//div[contains(text(),'" + prod + "')]/../../..//div[@class='inventory_item_desc']")).getText();
            String valprice = driver.findElement(By.xpath("//div[contains(text(),'" + prod + "')]/../../..//div[@class='inventory_item_price']")).getText();
            if (proddesc.equalsIgnoreCase(valdesc) && prodprice.equalsIgnoreCase(valprice)) {
                System.out.println("Product added successfully in cart");
            } else
                System.out.println("Product not added successfully in cart - Missing information");
        }
    }

    @And("Checkout")
    public void checkout() {
        driver.findElement(By.xpath("//div/a[contains(text(),'CHECKOUT')]")).click();
    }

    @And("Verify product details Checkout")
    public void verifyProductDetailsCheckout() throws InterruptedException {
        Thread.sleep(4000);
        if (driver.findElements(By.xpath("//div[contains(text(),'" + prod + "')]")).size() > 0) {
            String valdesc = driver.findElement(By.xpath("//div[contains(text(),'" + prod + "')]/../../..//div[@class='inventory_item_desc']")).getText();
            String valprice = driver.findElement(By.xpath("//div[contains(text(),'" + prod + "')]/../../..//div[@class='inventory_item_price']")).getText();
            if (proddesc.equalsIgnoreCase(valdesc) && prodprice.equalsIgnoreCase(valprice)) {
                System.out.println("Product added successfully in cart");
            } else
                System.out.println("Product not added successfully in cart - Missing information");
        }
    }

    @Then("Verify success message")
    public void verifySuccessMessage() throws InterruptedException {
        Thread.sleep(2000);
        if(driver.findElements(By.xpath("//div[contains(text(),'Your order has been dispatched, and will arrive just as fast as the pony can get')]")).size()>0){
            System.out.println("Product added and got success message after placing order");
        }
        else
            System.out.println("success message not got");
    }

    @And("Finish")
    public void finish() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/a[contains(text(),'FINISH')]")).click();
    }

    @And("Enter checkout information")
    public void enterCheckoutInformation() {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Firstname");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Lastname");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
    }

    @And("Continue Checkout")
    public void continueCheckout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
        if(driver.findElements(By.xpath("//div[contains(text(),'Checkout: Overview')]")).size()>0){
            System.out.println("Checkout over page");
        }
    }

    @And("Continue shopping")
    public void continueShopping() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/a[contains(text(),'Continue Shopping')]")).click();
        Thread.sleep(1000);
        if(driver.findElements(By.xpath("//div[contains(text(),'Product')]")).size()>0){
            System.out.println("Navigated to products page again");
        }
        else
            System.out.println("Not in products page");
    }

    @And("Close driver")
    public void closeDriver() {
        driver.close();
        driver.quit();
    }


}
