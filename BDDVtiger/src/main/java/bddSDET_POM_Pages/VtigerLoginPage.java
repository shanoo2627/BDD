package bddSDET_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {

	// Step 1: declaration - use @FindBy annotation
	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement submitBtn;

//	//Step 2: Initialization - use constructor
	public VtigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: Utilization - provide getters

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	// business Library
	public void loginToApp(String username, String password) {
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}

}
