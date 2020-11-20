package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateAccount {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'New User Register Here')]")
    WebElement NewUserRegister;

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement pwd;

    @FindBy(name="re_password")
    WebElement re_pwd;

    @FindBy(name="full_name")
    WebElement fullname;

    @FindBy(name="email_add")
    WebElement e_mail;

    @FindBy(name="captcha")
    WebElement captcha;

    @FindBy(name="tnc_box")
    WebElement chkbox;

    @FindBy(name="Submit")
    WebElement Submitbtn;
    public CreateAccount(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickCreate() {
        driver.findElement(By.xpath("//a[contains(text(),'New User Register Here')]")).click();
//        NewUserRegister.click();
    }

    public void enterRegistrationForm( String usrname, String passwd, String email,String fullnm, String capcha) {
        try{
            username.sendKeys(usrname);
            pwd.sendKeys(passwd);
            re_pwd.sendKeys(passwd);
            fullname.sendKeys(fullnm);
            e_mail.sendKeys(email);
            chkbox.click();
            clickRegister();
            Thread.sleep(5000);
            if(driver.findElements(By.xpath("//label[contains(text(),'Captcha is Empty')]")).size()>0){
                System.out.println("Getting error message");
            }
            else
                System.out.println("Able to register without captcha");
//            String captchaerr = driver.findElement(By.xpath("Captcha is Empty"))
//            Assert.assertEquals("","");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void clickRegister(){
        Submitbtn.click();
    }

    public void backToLoginPage(){
        driver.findElement(By.xpath("//a[contains(text(),'Go back to Login page')]")).click();
        System.out.println("Back to Login page");
    }


}
