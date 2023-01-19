package bddSDET_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerHomePage {

	// Step 1: Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;

	// Step 2: initialization
	public VtigerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: generate Getters
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	// Business Library
	public void clickOnOrgLnk() {
		organizationLnk.click();
	}

}
