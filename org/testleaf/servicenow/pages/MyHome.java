package com.testleaf.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class MyHome extends ProjectSpecificMethods{

	public MyHome() {
		PageFactory.initElements(getDriver(), this);
	}
	public MyHome printTitle() {
		System.out.println(verifyTitle("My Home | opentaps CRM"));
		return this;
	}
	@FindBy(how = How.LINK_TEXT, using="Leads")
	private WebElement leads;
	public LeadsPage clickOnLeads(){
		click(leads);
	return new LeadsPage();
	}
}
