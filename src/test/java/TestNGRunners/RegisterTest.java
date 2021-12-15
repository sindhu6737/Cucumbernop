package TestNGRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/Features/registeration.feature"},
		glue= {"automation"},
		tags= "@Smoke"
		)
public class RegisterTest extends AbstractTestNGCucumberTests {

}
