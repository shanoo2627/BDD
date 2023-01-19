package bddSDET_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateOrganizationsPage {

	// Step 1: Declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// Step 2: initialization
	public VtigerCreateOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// Business Library
	/**
	 * This method will create new organization
	 * 
	 * @param orgName
	 */
	public void createNewOrg(String orgName) {
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}

	/**
	 * this method will create new organization with industry drop down
	 * 
	 * @param orgName
	 * @param indType
	 */

}
