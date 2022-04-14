package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "@target/rerun.txt",
        glue = "steps"// path for Java class with steps


)

public class ReRunner {
}
