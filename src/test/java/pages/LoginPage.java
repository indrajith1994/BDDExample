package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "username")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void loginWithCredentials(String user,String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
}
