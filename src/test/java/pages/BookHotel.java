package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookHotel {
    WebDriver driver;

    @FindBy(name="continue")
    WebElement continuebtn;

    @FindBy(xpath="//label[contains(text(),'Please Select a Hotel')]")
    WebElement pagerr1;

    @FindBy(xpath="//input[@name='radiobutton_1']")
    WebElement firstHotel;

    @FindBy(xpath="//td[contains(text(),'Book A Hotel')]")
    WebElement bookhotelpage;

    @FindBy(name="first_name")
    WebElement Firstname;

    @FindBy(name="last_name")
    WebElement Lastname;

    @FindBy(name="address")
    WebElement Address;

    @FindBy(xpath="//td[text()='Credit Card Type']/following-sibling::td//select")
    WebElement cc_cardDropdown;

    @FindBy(xpath="//td[text()='Expiry Date']/following-sibling::td//select[@name='cc_exp_month']")
    WebElement cc_exp_month;

    @FindBy(xpath="//td[text()='Expiry Date']/following-sibling::td//select[@name='cc_exp_year']")
    WebElement cc_exp_year;

    @FindBy(xpath="//input[@name='cc_cvv']")
    WebElement cc_cvv;

    @FindBy(xpath="//input[@name='book_now']")
    WebElement booknowbtn;

    @FindBy(xpath="//label[contains(text(),'Please Enter your 16 Digit Credit Card Number')]")
    WebElement ccnumbermissing;

    @FindBy(xpath="//input[@name='cancel']")
    WebElement cancelbtn;


    public BookHotel(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public boolean SelectHotelValidation(){
        continuebtn.click();
        boolean selectHotel = pagerr1.isDisplayed();
        return selectHotel;
    }

    public void SelectHotel() throws InterruptedException {
        firstHotel.click();
        continuebtn.click();
        Thread.sleep(5000);
    }

    public boolean validateBookHotelpage(){
        boolean BookHotelpage = bookhotelpage.isDisplayed();
        return BookHotelpage;
    }

    public void BookHotelform(String firstname, String lastname, String address, String cvv){
        Firstname.sendKeys(firstname);
        Lastname.sendKeys(lastname);
        Address.sendKeys(address);
        Select cardtype = new Select(cc_cardDropdown);
        cardtype.selectByIndex(2);
        Select ccmonth = new Select(cc_exp_month);
        ccmonth.selectByIndex(2);
        Select ccyear = new Select(cc_exp_year);
        ccyear.selectByValue("2022");
        cc_cvv.sendKeys(cvv);
        BookNow();
        boolean ccnum = creditcarderror();
        if (ccnum) {
            System.out.println("Getting error message to enter credit card number");
        }
        Cancel();

    }

    public void BookNow(){
        booknowbtn.click();
    }

    public boolean creditcarderror(){
        boolean creditcarderror = ccnumbermissing.isDisplayed();
        return creditcarderror;
    }

    public void Cancel(){
        cancelbtn.click();
    }
}
