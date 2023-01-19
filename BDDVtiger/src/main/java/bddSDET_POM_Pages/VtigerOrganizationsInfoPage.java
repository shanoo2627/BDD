package bddSDET_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganizationsInfoPage {
	// Step 1: declaration
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement headerText;

	// Step 2: initialization
	public VtigerOrganizationsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: utilization
	public WebElement getHeaderText() {
		return headerText;
	}

	// business library
	public String OrgNameInfo() {
		String OrgInfo = headerText.getText();
		return OrgInfo;
	}

}
