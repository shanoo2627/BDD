package stepDefinationsAndHooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import bddSDET_GenericUtility.PropertyFile;
import bddSDET_Injector.Base;
import bddSDET_POM_Pages.VtigerLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook {

	Base base;

	public Hook(Base base) {
		this.base=base;
	}

	@Before
	public void SetUp() throws Throwable {
		String browser = PropertyFile.readDataFromPropertyFile("browser");
		String url = PropertyFile.readDataFromPropertyFile("url");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver = new ChromeDriver();
			base.driver.manage().window().maximize();
			base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			base.driver.get(url);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver = new FirefoxDriver();
			base.driver.manage().window().maximize();
			base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			base.driver.get(url);
		} else {
			System.out.println("Enter Valid Browser Name");
		}
		VtigerLoginPage loginPage = new VtigerLoginPage(base.driver);
		String username = PropertyFile.readDataFromPropertyFile("username");
		String password = PropertyFile.readDataFromPropertyFile("password");
		loginPage.loginToApp(username, password);

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot takeScreenShot = (TakesScreenshot) base.driver;
			byte[] screenShot = takeScreenShot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenario.getName());
		}

		base.driver.quit();
	}

}
