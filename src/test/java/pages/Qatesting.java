package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;

public class Qatesting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
//		String newWindow = driver.getWindowHandle();
		driver.manage().window().setSize(new Dimension(1024,768));
		driver.manage().window().setSize(new Dimension(1200,200));
		driver.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys("ucealer motion 6 single pk");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
//		((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
//		System.out.println("opened");
		
		Thread.sleep(5000);
		driver.quit();
		

		
		
	}

}
