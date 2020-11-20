package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	WebDriver driver;
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	WebElement pageText;
	
	public SelectHotelPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public boolean validateSelectHotelPage() {
		boolean selectHotelText = pageText.isDisplayed();
		return selectHotelText;
	}

}
