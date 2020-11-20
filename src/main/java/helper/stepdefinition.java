package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

public class stepdefinition {
	WebDriver driver = null;

	@Given("I enter the URL in the browser")
	public void i_enter_the_url_in_the_browser() {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		 driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		
		
	}

	@When("I enter username and password and login button")
	public void i_enter_username_and_password_and_login_button(String username,String password) {

		driver.findElement(By.id("")).sendKeys(username);
		driver.findElement(By.id("")).sendKeys(password);

	}

	@And("I validate the login credentials")
	public void i_validate_the_login_credentials() {

		
	}
	    
	@Then("I validate the application")
	public void i_validate_the_application() {
		driver.close();
		driver.quit();
	}

	@When("I enter {string} and {string} and login button")
	public void iEnterAndAndLoginButton(String arg0, String arg1) {
	}


}
