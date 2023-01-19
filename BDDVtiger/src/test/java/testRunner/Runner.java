package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {".\\src\\test\\java\\featuers"},
		glue = {"stepDefinationsAndHooks"},
		dryRun = false,
		monochrome = true,
		tags = "",
		plugin = {
				"pretty",
				"html:BDDHtmlReports.html",
				"json:BDDJsonReports.json"	
		}
		
		
		
		
		)

public class Runner extends AbstractTestNGCucumberTests {

}
