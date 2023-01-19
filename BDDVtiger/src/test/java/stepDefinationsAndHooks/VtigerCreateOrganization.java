package stepDefinationsAndHooks;

import java.util.Random;

import org.testng.Assert;

import bddSDET_Injector.Base;
import bddSDET_POM_Pages.VtigerCreateOrganizationsPage;
import bddSDET_POM_Pages.VtigerHomePage;
import bddSDET_POM_Pages.VtigerOrganizationsInfoPage;
import bddSDET_POM_Pages.VtigerOrganizationsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VtigerCreateOrganization {
	Base base;
	public VtigerCreateOrganization(Base base) {
		this.base=base;
	}
	
	@When("Homepage is displayed click on organization link")
	public void homepage_is_displayed_click_on_organization_link() {
		VtigerHomePage homePage = new VtigerHomePage(base.driver);
		homePage.clickOnOrgLnk();
			
	}
	@When("organizations page click on create new organization image")
	public void organizations_page_click_on_create_new_organization_image() {
		VtigerOrganizationsPage orgPage=new VtigerOrganizationsPage(base.driver);
		orgPage.clickOnCreateOrgImg();
		
		
	}
	@When("create new organization page enter madatory fields and click on save button")
	public void create_new_organization_page_enter_madatory_fields_and_click_on_save_button() {
		int randomNumber = new Random().nextInt(100);
		VtigerCreateOrganizationsPage createNewOrg = new VtigerCreateOrganizationsPage(base.driver);
		createNewOrg.createNewOrg("TestYantra"+randomNumber);
		
	}
	@Then("Verify organization is created or not")
	public void verify_organization_is_created_or_not() {
		VtigerOrganizationsInfoPage orgInfoPage = new VtigerOrganizationsInfoPage(base.driver);
		String actualOrgName = orgInfoPage.OrgNameInfo();
		Assert.assertTrue(actualOrgName.contains("TestYantra"));

	}

}
