package testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import BDDExample.BDDExample.DemoqaBase;
import demoqa.*;

public class DemoQa extends DemoqaBase {
    @Test //Scenario-1
    public void ElementsSection() throws InterruptedException {
        Thread.sleep(5000);

        Elements elements = new Elements(driver);
        Thread.sleep(5000);
        elements.Elementstab();

        Links links = new Links(driver);
        Thread.sleep(2000);
        links.Linkstab();
        Thread.sleep(2000);
        links.linkscount();

    }

    @Test //Scenario-2
    public void CheckBox() throws InterruptedException {
        Thread.sleep(3000);

        Elements elements = new Elements(driver);
        Thread.sleep(3000);
        elements.Elementstab();

        Checkbox checkbox = new Checkbox(driver);
        checkbox.checkboxheader();
        String[] val = {"Home","Downloads"};
        System.out.println(val[0]);
        System.out.println(val[1]);

        checkbox.Navigate(val[0]);
        checkbox.Navigate(val[1]);
        checkbox.selectExcel();

    }

    @Test //Scenario-3
    public void Webtable() throws InterruptedException {
        Thread.sleep(1000);

        Elements elements = new Elements(driver);
        Thread.sleep(3000);
        elements.Elementstab();

        WebTables webTables = new WebTables(driver);
        webTables.webtableheader();
        webTables.addButton();
        webTables.registrationForm("First","name","test@test.com","23","10000","testing");
        webTables.submitbtn();
        webTables.validateNewRecord("First","name","test@test.com","23","10000","testing");

    }

    @Test //Scenario-4
    public void Forms() throws InterruptedException {

        Thread.sleep(1000);

        Elements elements = new Elements(driver);
        Thread.sleep(3000);
        elements.Elementstab();
        FormHandling formHandling = new FormHandling(driver);
        formHandling.practiceformtab();
        formHandling.fillform("fname","lname","test@testin.com","Male","1234567890","08 Jab 2000","Maths","Sports","address");


    }

}
