import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Power.feature",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunPowerTest {
}
