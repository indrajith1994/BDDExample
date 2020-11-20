package helper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homepageTest {
    WebDriver driver;
    @Given("I enter the application {string} in the browser")
    public void i_enter_the_application_in_the_browser(String string) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

         driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.get(string);
        driver.manage().window().maximize();

    }


    @When("I navigated to homepage")
    public void i_navigated_to_homepage() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("i_navigated_to_homepage");
    }

    @Then("I validate the user navigated to the screen")
    public void i_validate_the_user_navigated_to_the_screen() {
//        driver.findElement(By.name("uid")).sendKeys("mngr287693");
        System.out.println("i_validate_the_user_navigated_to_the_screen");
        driver.close();
        driver.quit();
    }

    @And("I search for the name with user logged in")
    public void iSearchForTheNameWithUserLoggedIn() {
        System.out.println("iSearchForTheNameWithUserLoggedIn");
    }
}
