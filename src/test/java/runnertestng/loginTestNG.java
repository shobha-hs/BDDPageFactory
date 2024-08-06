package runnertestng;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/resources/features/LoginPage.feature",
		glue="steps",
		plugin = { "pretty", "html:target/cucumber-reports/cucumber-report.html" },
		monochrome = true
		 
		)

public class loginTestNG extends AbstractTestNGCucumberTests{


	@Test
	public void runCukes() {
		
		
		
	}
}
