package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/Features/registeration.feature"},
		glue= {"StepDefinitions","Hooks"},
		tags= "@Smoke"
		)

public class RegisterTest {

}
