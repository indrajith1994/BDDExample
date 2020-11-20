package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sampleTest {
	@Given("I enter the {string} in the browser")
	public void i_enter_the_in_the_browser(String string) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get(string);
		driver.manage().window().maximize();
	}


	@When("I enter username and password and login button sandeep")
	public void i_enter_username_and_password_and_login_button_sandeep() {

	}

	@When("I validate the login credentials in the application")
	public void i_validate_the_login_credentials_in_the_application() {

	}

	@Then("I validate the logout  step in application")
	public void i_validate_the_logout_step_in_application() {

	}




}
