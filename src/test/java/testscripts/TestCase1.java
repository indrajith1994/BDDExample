package testscripts;


import org.testng.annotations.Test;
import BDDExample.BDDExample.BasePage;
import pages.*;

public class TestCase1 extends BasePage {

    @Test //Scenario-1
    public void createNewUser() throws InterruptedException {
        Thread.sleep(5000);

        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.clickCreate();
        createAccount.enterRegistrationForm(getPropertyValue("USRNAME"), getPropertyValue("PASSWD"), getPropertyValue("EMAIL"),getPropertyValue("FULLNAME"),getPropertyValue("CAPTCHA"));
        createAccount.backToLoginPage();
    }

    @Test //Scenario-2
    public void validateNewUserForm() throws InterruptedException {

        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials(getPropertyValue("USERNAME"), getPropertyValue("PASSWORD"));
        Thread.sleep(5000);


        HomePage homePage = new HomePage(driver);
        homePage.validateForm(getPropertyValue("LoggedInText"));
        System.out.println("Validated the user login..");
        homePage.selectValues();
        homePage.clickSearchButton();

        SelectHotelPage selHotel = new SelectHotelPage(driver);
        boolean hotelPage = selHotel.validateSelectHotelPage();
        if (hotelPage) {
            System.out.println("Page navigated to Select Hotel Page Section..");
        }

    }

    @Test //Scenario-3
    public void bookHotelValidation() throws InterruptedException {

        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials(getPropertyValue("USERNAME"), getPropertyValue("PASSWORD"));
        Thread.sleep(5000);


        HomePage homePage = new HomePage(driver);
        homePage.validateForm(getPropertyValue("LoggedInText"));
        System.out.println("Validated the user login..");
        homePage.selectValues();
        homePage.clickSearchButton();

        SelectHotelPage selHotel = new SelectHotelPage(driver);
        boolean hotelPage = selHotel.validateSelectHotelPage();
        if (hotelPage) {
            System.out.println("Page navigated to Select Hotel Page Section..");
        }

        BookHotel bookHotel = new BookHotel(driver);
        boolean hotelPage1 = bookHotel.SelectHotelValidation();
        if (hotelPage1) {
            System.out.println("Please Select a Hotel error message is visible");
        }

        bookHotel.SelectHotel();

        boolean hotelPage2 = bookHotel.validateBookHotelpage();
        if (hotelPage2) {
            System.out.println("Page navigated to Book A Hotel");
        }

    }

    @Test //Scenario-4
    public void bookHotelForm() throws InterruptedException {
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials(getPropertyValue("USERNAME"), getPropertyValue("PASSWORD"));
        Thread.sleep(5000);


        HomePage homePage = new HomePage(driver);
        homePage.validateForm(getPropertyValue("LoggedInText"));
        System.out.println("Validated the user login..");
        homePage.selectValues();
        homePage.clickSearchButton();

        SelectHotelPage selHotel = new SelectHotelPage(driver);
        boolean hotelPage = selHotel.validateSelectHotelPage();
        if (hotelPage) {
            System.out.println("Page navigated to Select Hotel Page Section..");
        }

        BookHotel bookHotel = new BookHotel(driver);
        boolean hotelPage1 = bookHotel.SelectHotelValidation();
        if (hotelPage1) {
            System.out.println("Please Select a Hotel error message is visible");
        }

        bookHotel.SelectHotel();

        boolean hotelPage2 = bookHotel.validateBookHotelpage();
        if (hotelPage2) {
            System.out.println("Page navigated to Book A Hotel");
        }

        bookHotel.BookHotelform(getPropertyValue("FIRSTNAME"),getPropertyValue("LASTNAME"),getPropertyValue("ADDRESS"),getPropertyValue("CVV"));
        Thread.sleep(5000);
        boolean hotelPage3 = selHotel.validateSelectHotelPage();
        if (hotelPage3) {
            System.out.println("Page navigated to Select Hotel Page after clicking cancel button");
        }

    }


}
