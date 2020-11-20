    package BDDExample.BDDExample;

    import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features={"/Users/indrajit/Downloads/BDDExample/features/Demo.feature"},
//            glue={"APIUtil","newAccountCreation"},
            glue={"onlineShop"},
            monochrome=true)

    public class RunnerShopping {

    }

