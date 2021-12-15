package TestNGRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/Features/search.feature"},
		glue= {"automation"},
		tags= "@Smoke"
		)
public class searchTest extends AbstractTestNGCucumberTests {

}
