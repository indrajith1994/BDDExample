package BDDExample.BDDExample;

import org.testng.annotations.Test;

public class priority {
    @Test(priority = 2)
    public void testtwo(){
        System.out.println("Priority 2");
    }
    @Test(priority = 1)
    public void testone(){
        System.out.println("Priority 1");
    }
    @Test(priority = 0)
    public void testzero(){
        System.out.println("Priority 0");
    }

    @Test()
    public void testnoprioa(){
        System.out.println("no Priority a");
    }
    @Test()
    public void testnopriob(){
        System.out.println("no Priority b");
    }
    @Test(priority = -1)
    public void testminusone() throws InterruptedException {
        System.out.println("Priority -1");
//        Thread.sleep(1000);
//        selenium.setSpeed(1000);
    }

    @Test(priority = -2)
    public void testminustwo(){
        System.out.println("Priority -2");
    }
}
