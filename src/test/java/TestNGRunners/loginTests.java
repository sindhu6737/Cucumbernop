package TestNGRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/Features/login.feature"},
		glue= {"automation"},
		
		tags= "@Smoke"
		)
public class loginTests extends AbstractTestNGCucumberTests {

}
