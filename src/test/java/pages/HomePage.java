package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(id="username_show")
	WebElement loggedinText;
	
	@FindBy(xpath="//td[text()='Location']/following-sibling::td//select")
	WebElement locationDropdown;
	
	@FindBy(xpath="//td[text()='Number of Rooms']/following-sibling::td//select")
	WebElement numberOfRooms;
	
	@FindBy(xpath="//td[text()='Adults per Room']/following-sibling::td//select")
	WebElement adultsPerRoom;
	
	@FindBy(id="Submit")
	WebElement searchButton;
	
	
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public void validateForm(String exp) {
		Assert.assertEquals(loggedinText.getAttribute("value"), exp);
	}
	
	public void selectValues() {
		
		Select location = new Select(locationDropdown);
		location.selectByIndex(5);
		
		Select numOfRooms = new Select(numberOfRooms);
		numOfRooms.selectByIndex(2);

		Select adultsRoom = new Select(adultsPerRoom);
		adultsRoom.selectByIndex(2);
				
	}
	

	public void clickSearchButton() {
		searchButton.click();
	}
}
