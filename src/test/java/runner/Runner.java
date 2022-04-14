package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

       plugin = {"json:target/cucumber.json"},
      features =  "src/test/resources/features",// path for feature files
        glue = "steps",// path for Java class with steps
        tags = "@MB2P-120",
        dryRun = true

)

public class   Runner {
}
