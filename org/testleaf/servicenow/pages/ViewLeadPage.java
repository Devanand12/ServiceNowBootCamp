package com.testleaf.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	public ViewLeadPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(how = How.ID, using="viewLead_companyName_sp")
	private WebElement testleaf;
	public void getTextOfTestleaf(){
		reportStep("Created lead id "+getElementText(testleaf), "pass");
	//return page;
	}

}
