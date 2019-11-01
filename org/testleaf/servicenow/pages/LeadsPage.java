package com.testleaf.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods{
	public LeadsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(how = How.LINK_TEXT, using="Create Lead")
	private WebElement createLead;
	public CreateLeadPage clickOnCreateLead(){
		click(createLead);
	return new CreateLeadPage();
	}
	
}
