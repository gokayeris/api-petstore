package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty",
                "html:testResults/output.html",
                "json:testResults/output.json",
        },
        features="src/test/resources/features",
        glue="stepDefinitions",

        tags="@pet",
        dryRun=false


)
public class Runner {

}