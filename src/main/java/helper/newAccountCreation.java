package helper;


import APIUtil.BaseFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

import static APIUtil.xpathlink.*;


public class newAccountCreation extends BaseFile {
    public static WebDriver driver;

    public static String usrid = null;
    public static String usrpwd = null;

    public void driverclose() {
        driver.close();
        driver.quit();
    }

//    @Before
//    public void setUp() throws InterruptedException {
//        System.out.println("Before");
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//        driver = new ChromeDriver();
//        Thread.sleep(5000);
//    }
//
//    @After
//    public void tearDown() {
//        System.out.println("After");
//		driver.close();
//		driver.quit();
//	}

    @Given("I navigate to the URL {string} and click on SignIn link")
    public void iNavigateToTheURLAndClickOnSignInLink(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("I enter email address {string}and click on Create an account button")
    public void iEnterEmailAddressAndClickOnCreateAnAccountButton(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/a[contains(text(),'Sign in')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        driver.findElement(By.id("email_create")).sendKeys(arg0);
        driver.findElement(By.xpath("//button[@id='SubmitCreate']//span")).click();
        Thread.sleep(3000);
        if (driver.findElements(By.xpath("//h1[contains(text(),'Create an account')]")).size() > 0) {
            System.out.println("Able to create new user");
        } else
            System.out.println("ID already available");

    }


    @And("I fill up the new account form with the following data and click on Register button")
    public void iFillUpTheNewAccountFormWithTheFollowingDataAndClickOnRegisterButton(DataTable table) {

        List<Map<String, String>> list = table.asMaps();

        System.out.println(list.get(0).get("FirstName"));
        System.out.println(list.get(0).get("LastName"));
        System.out.println(list.get(0).get("Email"));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Create an account')]")));
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(list.get(0).get("FirstName"));
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(list.get(0).get("LastName"));
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(list.get(0).get("Password"));
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(list.get(0).get("Address"));
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(list.get(0).get("City"));
        WebElement DropDown1 = driver.findElement(By.id("id_state"));
        Select statedropdown = new Select(DropDown1);
        statedropdown.selectByVisibleText(list.get(0).get("State"));
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(list.get(0).get("PostCode"));
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(list.get(0).get("PhoneNumber"));
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(list.get(0).get("AddressAlias"));
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

    }

    @Then("The user should be able to create an account")
    public void theUserShouldBeAbleToCreateAnAccount() {
        driverclose();
    }


    @When("I move cursor to Dresses and click on Casual dresses")
    public void iMoveCursorToDressesAndClickOnCasualDresses() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]"));
        actions.moveToElement(menuOption).perform();
        Thread.sleep(3000);
        menuOption = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]/..//li/a[@title='Casual Dresses']"));
        actions.moveToElement(menuOption).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]/..//li/a[@title='Casual Dresses']")).click();
        Thread.sleep(5000);
    }

    @And("I add the items to the cart and navigate til checkout page")
    public void iAddTheItemsToTheCartAndNavigateTilCheckoutPage() throws InterruptedException {
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        WebElement menuOption1 = driver.findElement(By.xpath("//span[@class='availability']"));
        actions.moveToElement(menuOption1).perform();
        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
    }

    @And("I increase the quantity by clicking + icon from Qty section and click on checkout button")
    public void iIncreaseTheQuantityByClickingIconFromQtySectionAndClickOnCheckoutButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title=\"Add\"]/span/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p//span[contains(text(),'Proceed to checkout')]")).click();
        Thread.sleep(3000);
    }

    @Then("I Validate that the User is navigated to Login page")
    public void ivalidateThatTheUserIsNavigatedToLoginPage() throws InterruptedException {
        Thread.sleep(2000);
        if (driver.findElements(By.xpath("//h3[contains(text(),'Create an account')]")).size() > 0 && driver.findElements(By.xpath("//h3[contains(text(),'Already registered')]")).size() > 0) {
            System.out.println("Login page while check out");
        } else
            System.out.println("Not getting to login page while checkout");
        driverclose();
    }

    @When("I click on Signin link and click on register now")
    public void iClickOnSigninLinkAndClickOnRegisterNow() throws InterruptedException {
        driver.findElement(By.xpath(petstoresignin)).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(petstoreregister)).click();
    }


    @And("I should navigate to User information page and enter all details")
    public void iShouldNavigateToUserInformationPageAndEnterAllDetails(DataTable table) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(petstore_userinfopage)));
        if (driver.findElements(By.xpath(petstore_userinfopage)).size() > 0) {
            System.out.println("Reached user info page and need to enter user details");
            List<Map<String, String>> list = table.asMaps();
            try {
                driver.findElement(By.xpath(petstore_reg_uid)).sendKeys(list.get(0).get("uid"));
                driver.findElement(By.xpath(petstore_reg_pwd)).sendKeys(list.get(0).get("Password"));
                driver.findElement(By.xpath(petstore_reg_reppwd)).sendKeys(list.get(0).get("Password"));
                driver.findElement(By.xpath(petstore_reg_fname)).sendKeys(list.get(0).get("FirstName"));
                driver.findElement(By.xpath(petstore_reg_lname)).sendKeys(list.get(0).get("LastName"));
                driver.findElement(By.xpath(petstore_reg_email)).sendKeys(list.get(0).get("Email"));
                driver.findElement(By.xpath(petstore_reg_phone)).sendKeys(list.get(0).get("PhoneNumber"));
                driver.findElement(By.xpath(petstore_reg_addr)).sendKeys(list.get(0).get("Address"));
                driver.findElement(By.xpath(petstore_reg_city)).sendKeys(list.get(0).get("City"));
                driver.findElement(By.xpath(petstore_reg_state)).sendKeys(list.get(0).get("State"));
                driver.findElement(By.xpath(petstore_reg_zip)).sendKeys(list.get(0).get("PostCode"));
                driver.findElement(By.xpath(petstore_reg_country)).sendKeys(list.get(0).get("Country"));
                if (list.get(0).get("Mylist").equalsIgnoreCase("yes")) {
                    driver.findElement(By.xpath(petstore_reg_mylist)).click();
                }
                if (list.get(0).get("Mybanner").equalsIgnoreCase("yes")) {
                    driver.findElement(By.xpath(petstore_reg_mybanner)).click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath(petstore_reg_btn)).click();
            Thread.sleep(3000);
            if (driver.findElements(By.xpath(petstoresignin)).size() > 0) {
                usrid = list.get(0).get("uid");
                usrpwd = list.get(0).get("Password");
//                helpprop.updateprop("USERID",usrid);
//                helpprop.updateprop("USERPWD",usrpwd);
                Thread.sleep(2000);
            }
        }
    }

    @Then("Login with userid")
    public void loginWithUserid() {
        try {
            driver.findElement(By.xpath(petstoresignin)).click();
            Thread.sleep(1000);
            System.out.println(usrid + usrpwd);
            driver.findElement(By.xpath(petstore_reg_uid)).sendKeys(usrid);
            driver.findElement(By.xpath(petstore_reg_pwd)).clear();
            driver.findElement(By.xpath(petstore_reg_pwd)).sendKeys(usrpwd);
            driver.findElement(By.xpath(petstoresignon)).click();
            Thread.sleep(3000);
            if (driver.findElements(By.xpath(petstore_signout)).size() > 0 && driver.findElements(By.xpath(petstore_myacc)).size() > 0) {
                System.out.println("Login Success - Account created");
            } else
                System.out.println("Account not created");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        driverclose();
    }

    @When("Sign in with valid userid")
    public void signInWithValidUserid() {
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath(petstoresignin)).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath(petstore_reg_uid)).sendKeys(getPropertyValue("USERID"));
            driver.findElement(By.xpath(petstore_reg_pwd)).clear();
            driver.findElement(By.xpath(petstore_reg_pwd)).sendKeys(getPropertyValue("USERPWD"));
            driver.findElement(By.xpath(petstoresignon)).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("Add product and update cart qty and checkout")
    public void addProductAndUpdateCartQtyAndCheckout(DataTable table) {
        try {
            List<Map<String, String>> list = table.asMaps();
            int count = list.size();
            int num;
            float payment = 0;
            for (num = 0; num < count; num++) {
                if (list.get(num).get("Pets").equalsIgnoreCase("Birds")) {
                    driver.findElement(By.xpath(petstore_birds)).click();
                }
                if (list.get(num).get("Pets").equalsIgnoreCase("Fish")) {
                    driver.findElement(By.xpath(petstore_fish)).click();
                }
                driver.findElement(By.xpath("//div[@id='Catalog']//a[contains(text(),'" + list.get(num).get("product") + "')]")).click();
                driver.findElement(By.xpath("//a[contains(text(),'" + list.get(num).get("Itemid") + "')]/../../td/a[contains(text(),'Add to Cart')]")).click();
                driver.findElement(By.xpath("//td[contains(text(),'" + list.get(num).get("product") + "')]/../td/input")).clear();
                driver.findElement(By.xpath("//td[contains(text(),'" + list.get(num).get("product") + "')]/../td/input")).sendKeys(list.get(num).get("Qty"));
                driver.findElement(By.xpath(updateCart)).click();
                String amount = driver.findElement(By.xpath("//a[contains(text(),'" + list.get(num).get("Itemid") + "')]/../../td[6]")).getText();
                float amt = Float.parseFloat(amount.replace("$", ""));
                amt = amt * Float.parseFloat(list.get(num).get("Qty"));
                String totamt = driver.findElement(By.xpath("//a[contains(text(),'" + list.get(num).get("Itemid") + "')]/../../td[7]")).getText();
                float Totamt = Float.parseFloat(totamt.replace("$", ""));
                if (Totamt == amt) {
                    payment = payment + amt;
                    System.out.println("Amount got updated successfully " + payment);
                }
            }
            driver.findElement(By.xpath(proceedCheckout)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(continuepayment)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(confirmCheckout)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Validate the order number in the submitted page")
    public void validateTheOrderNumberInTheSubmittedPage() throws InterruptedException {
        if (driver.findElements(By.xpath(orderConfirmation)).size() > 0) {
            System.out.println("Order placed done");
        } else
            System.out.println("Order not placed - Failed");
        Thread.sleep(3000);
    }

}

