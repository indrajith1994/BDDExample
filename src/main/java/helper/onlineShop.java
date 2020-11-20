package helper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class onlineShop {

    WebDriver driver;

    public onlineShop(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String homePage;
    public static String desc;

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";


        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

//    public static WebDriver driver;

//    @Before
//    public void setUp() throws InterruptedException {
//        System.out.println("Start");
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//        driver = new ChromeDriver();
//        Thread.sleep(5000);
//
//    }
//
//    @After
//    public void tearDown() {
//        System.out.println("end");
//        driver.close();
//        driver.quit();
//    }

    @Given("I navigate to the URL {string}")
    public void iNavigateToTheURL(String url) throws InterruptedException {
        driver.get(url);
        homePage = url;
        Thread.sleep(5000);
        driver.manage().window().maximize();
    }

    @When("I click on SignUp link")
    public void iClickOnSignUpLink() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertmsg = driver.switchTo().alert().getText();
        if (alertmsg.equalsIgnoreCase("Please fill out Username and Password.")) {
            alert.accept();
        }
    }

    @And("Give User information on page")
    public void giveUserInformationOnPage() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(getAlphaNumericString(6));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys(getAlphaNumericString(6));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        Thread.sleep(2000);

    }

    @Then("validate the success msg")
    public void validateTheSuccessMsg() {
        Alert alert = driver.switchTo().alert();
        String alertmsg = driver.switchTo().alert().getText();
        if (alertmsg.equalsIgnoreCase("Sign up successful.")) {
            alert.accept();
        }
    }

    @When("select product and validate price and description")
    public void selectProductAndValidatePriceAndDescription(DataTable table) {
        try {
            List<Map<String, String>> list = table.asMaps();
            int count = list.size();
            int num;
            for (num = 0; num < count; num++) {
                Thread.sleep(5000);
                desc = driver.findElement(By.xpath("//a[contains(text(),'" + list.get(num).get("product") + "')]/../../p")).getText();
                driver.findElement(By.xpath("//a[contains(text(),'" + list.get(num).get("product") + "')]")).click();
                Thread.sleep(2000);
                String des = driver.findElement(By.xpath("//h2[contains(text(),'" + list.get(num).get("product") + "')]/..//p")).getText();
                if (desc.equalsIgnoreCase(des)) {
                    System.out.println("Desc is matching");
                }
                driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
                Thread.sleep(3000);
                Alert alert = driver.switchTo().alert();
                String alertmsg = driver.switchTo().alert().getText();
                if (alertmsg.equalsIgnoreCase("Product added")) {
                    alert.accept();
                }
                driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("fill the form and validate success msg")
    public void fillTheFormAndValidateSuccessMsg() {
        try {
            driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(getAlphaNumericString(5));
            driver.findElement(By.xpath("//input[@id='country']")).sendKeys(getAlphaNumericString(5));
            driver.findElement(By.xpath("//input[@id='city']")).sendKeys(getAlphaNumericString(5));
            driver.findElement(By.xpath("//input[@id='card']")).sendKeys(getAlphaNumericString(5));
            driver.findElement(By.xpath("//input[@id='month']")).sendKeys(getAlphaNumericString(5));
            driver.findElement(By.xpath("//input[@id='year']")).sendKeys(getAlphaNumericString(4));

            driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();

            if (driver.findElements(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).size() > 0) {
                String orderdetails = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]/../../div/p")).getText();
                System.out.println("order details " + orderdetails);
            }
            driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Then("display broken links")
    public void displayBrokenLinks() {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("List of url found " + links.size());
        for (WebElement Links : links) {
            if (Links.getText().isEmpty() || Links.getAttribute("href").isEmpty()) {
                continue;
            }
            System.out.println(Links.getText() + " -- " + Links.getAttribute("href"));
        }

        Iterator<WebElement> it = links.iterator();

//        while (it.hasNext()) {
//
//            url = it.next().getAttribute("href");
//            System.out.println(it.next().getText()+" URL "+it.next().getAttribute("href"));
//
//            if (url == null || url.isEmpty()) {
//                System.out.println("URL is either not configured for anchor tag or it is empty");
//                continue;
//            }
//            if (!url.startsWith(homePage)) {
//                System.out.println("URL belongs to another domain, skipping it.");
//                continue;
//            }
//            try {
//                huc = (HttpURLConnection) (new URL(url).openConnection());
//                huc.setRequestMethod("HEAD");
//                huc.connect();
//                Thread.sleep(500);
//                respCode = huc.getResponseCode();
//                System.out.println(respCode);
//                if (respCode == 200) {
////                    System.out.println(url + " response is 200");
//                    System.out.println("Above URL responsecode is 200");
//                }
//                else if (respCode >= 400) {
////                    System.out.println(url + " is a broken link");
//                    System.out.println("Above URL responsecode is "+respCode);
//                }
//				else{
////					System.out.println(url+" is a valid link");
//                    System.out.println("Above URL responsecode is "+respCode);
//				}
//
//            } catch (MalformedURLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
}
