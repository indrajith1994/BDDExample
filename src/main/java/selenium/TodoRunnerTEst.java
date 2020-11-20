package selenium;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features={"/Users/indrajit/Downloads/BDDExample/features/logout.feature"}
,glue={"helper","sampleTest"},monochrome=true,dryRun=true)
public class TodoRunnerTEst {

}
