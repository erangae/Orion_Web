package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty", "html:Features/html/"},
		features="Features",
		glue={"stepDefinition"})
public class TestRunner {

}
