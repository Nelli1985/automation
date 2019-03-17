package API;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"pretty","html:reports/test-report"},
        tags= "@api",
        features = "src/test/resources/features",
        junit = {"--step-notifications"})

public class CucumberRunnerTestAPI {
}